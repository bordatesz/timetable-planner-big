package hu.thesis.timetableplanner.controller;

import hu.thesis.timetableplanner.dto.CourseDto;
import hu.thesis.timetableplanner.dto.UserDto;
import hu.thesis.timetableplanner.form.CourseForm;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.service.CourseService;
import hu.thesis.timetableplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    //TODO kiegészíteni hogy hozzá lehessen adni felelőst egy külön oldalon? de akkor kéne edit, meg delete...
    @RequestMapping(value = "/admin/courses/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView listCourses(@PathVariable("pageNumber") int pageNumber,
                                  HttpServletRequest request, Principal principal) {

        if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
            return new ModelAndView("redirect:/permissionViolation");
        }

        ModelAndView model = new ModelAndView("admin/coursesList");
        Pagination<CourseDto> page = courseService.findAllCoursePageable(pageNumber);
        page.setPageName("admin/courses");
        model.addObject("page", page);

        return model;
    }

    @RequestMapping(value = "/admin/createCourse", method = RequestMethod.GET)
    public ModelAndView createCourseGet(HttpServletRequest request,
                                        @ModelAttribute String errorMessage, Principal principal) {

        if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
            return new ModelAndView("redirect:/permissionViolation");
        }

        ModelAndView model = new ModelAndView("admin/createCourse");
        CourseForm form = new CourseForm();
        List<UserDto> lecturers = userService.findByAuthorityName("ROLE_LECTURER");
        model.addObject("lecturers", lecturers);
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);

        return model;
    }

    @RequestMapping(value = "/admin/createCourse", method = RequestMethod.POST)
    public String createCoursePost(HttpServletRequest request,
                                   @Valid @ModelAttribute("form") CourseForm form,
                                   BindingResult result, RedirectAttributes redirectAttributes) {

        boolean courseExist = courseService.checkCourse(form.getName(), form.getCurricula(), form.getPeriod());

        if (!result.hasErrors()) {
            if (!courseExist) {
                courseService.createCourse(form);
                return "redirect:/admin/courses/1";
            } else {
                redirectAttributes.addFlashAttribute("errorMessage",
                        "This course is already exist");
                return "redirect:/admin/createCourse";
            }
        }
        redirectAttributes.addFlashAttribute("errorMessage",
                "There is some error" + result.toString());
        return "redirect:/admin/createCourse";

    }

    @RequestMapping(value = "/admin/editCourse/{id}", method = RequestMethod.GET)
    public ModelAndView editCourseGet(@PathVariable("id") long id,
                                    HttpServletRequest request, @ModelAttribute String errorMessage, Principal principal) {

        if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
            return new ModelAndView("redirect:/permissionViolation");
        }

        ModelAndView model = new ModelAndView("admin/editCourse");
        CourseForm form = new CourseForm();
        CourseDto course = courseService.findById(id);
        List<UserDto> lecturers = userService.findByAuthorityName("ROLE_LECTURER");
        form.setResponsible(course.getResponsible().getEmailAddress());

        model.addObject("course", course);
        model.addObject("lecturers", lecturers);
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);
        return model;
    }

    @RequestMapping(value = "/admin/editCourse/{id}", method = RequestMethod.POST)
    public String editCoursePost(@PathVariable("id") long id,
                               @Valid @ModelAttribute("form") CourseForm form,
                               BindingResult result, RedirectAttributes redirectAttribute,
                               HttpServletRequest request) {

        if (!result.hasErrors()) {
            courseService.editCourse(id, form);
            return "redirect:/admin/courses/1";
        }
        redirectAttribute.addFlashAttribute("errorMessage", "An error  occured: " + result.toString());
        return "redirect:/admin/editCourse/" + id;
    }

    @RequestMapping(value = "/admin/deleteCourse/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable("id") long id, Principal principal) {

        if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
            return "redirect:/permissionViolation";
        }
        courseService.deleteCourse(id);
        return "redirect:/admin/courses/1";
    }

    //TODO pageable?
    //TODO Nem a teachben lenne a helye?
    @RequestMapping(value = "/userCourses", method = RequestMethod.GET)
    public ModelAndView listUserCourses(Principal principal, HttpServletRequest request) {
        ModelAndView model = new ModelAndView("userCourseList");

        String actualUser =  principal.getName();
        List<CourseDto> userCourses = courseService.findAllUserCourse(actualUser);

        model.addObject("userCourses", userCourses);

        return model;
    }

    @RequestMapping(value = "/responsibilities", method = RequestMethod.GET)
    public ModelAndView listResponsibilities(HttpServletRequest request, Principal principal) {

        if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_COURSE_RESP")) {
            return new ModelAndView("redirect:/permissionViolation");
        }

        ModelAndView model = new ModelAndView("responsibilitiesList");
        List<CourseDto> responsibilities =  courseService.findByResponsibleEmailAddress(principal.getName());
        model.addObject("responsibilities", responsibilities);

        return model;
    }
}
