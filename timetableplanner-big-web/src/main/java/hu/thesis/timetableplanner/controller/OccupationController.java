package hu.thesis.timetableplanner.controller;

import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.dto.UserDto;
import hu.thesis.timetableplanner.form.OccupationForm;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.service.OccupationService;
import hu.thesis.timetableplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OccupationController {

    @Autowired
    private OccupationService occupationService;

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/occupations", method = RequestMethod.GET) //TODO pageable?
    public ModelAndView listUserOccupations(Principal principal, HttpServletRequest request) {
        ModelAndView model = new ModelAndView("occupationList");

        UserDto actualUser =  userService.findByEmailAddress(principal.getName());
        List<OccupationDto> userOccupations = actualUser.getOccupations();

        model.addObject("userOccupations", userOccupations);

        return model;
    }

    @RequestMapping(value = "/admin/occupations", method = RequestMethod.GET) //TODO pageable?
    public ModelAndView listOccupations(HttpServletRequest request, Principal principal) {

        if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
            return new ModelAndView("redirect:/permissionViolation");
        }

        ModelAndView model = new ModelAndView("admin/occupationList");

        List<UserDto> users = userService.findAllUser();
        model.addObject("users", users);

        return model;
    }

    @RequestMapping(value = "/addOccupation", method = RequestMethod.GET)
    public ModelAndView createUserOccupationGet(HttpServletRequest request,
                                      @ModelAttribute String errorMessage) {

        ModelAndView model = new ModelAndView("createOccupation");
        OccupationForm form = new OccupationForm();
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);

        return model;
    }

    @RequestMapping(value = "/addOccupation", method = RequestMethod.POST)
    public String createUserOccupationPost(Principal principal, HttpServletRequest request,
                                           @Valid @ModelAttribute("form") OccupationForm form,
                                 BindingResult result, RedirectAttributes redirectAttributes) {
        if (!result.hasErrors()) {
            occupationService.createUserOccupation(principal.getName(), form);
            return "redirect:/occupations";
        }
        redirectAttributes.addFlashAttribute("errorMessage",
                "There is some error" + result.toString());
        return "redirect:/addOccupation";

    }

    @RequestMapping(value = "/admin/addOccupation", method = RequestMethod.GET)
    public ModelAndView createOccupationGet(HttpServletRequest request, Principal principal,
                                                @ModelAttribute String errorMessage) {

        if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
            return new ModelAndView("redirect:/permissionViolation");
        }

        ModelAndView model = new ModelAndView("admin/createOccupation");
        OccupationForm form = new OccupationForm();
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);

        return model;
    }

    @RequestMapping(value = "/admin/addOccupation", method = RequestMethod.POST)
    public String createOccupationPost(HttpServletRequest request,
                                 @Valid @ModelAttribute("form") OccupationForm form,
                                 BindingResult result, RedirectAttributes redirectAttributes) {
        if (!result.hasErrors()) {
            occupationService.createOccupation(form);
            return "redirect:/admin/occupations/1";
        }
        redirectAttributes.addFlashAttribute("errorMessage",
                "There is some error" + result.toString());
        return "redirect:/admin/addOccupation";

    }

    @RequestMapping(value = "/editOccupation/{id}", method = RequestMethod.GET)
    public ModelAndView editUserOccupationGet(@PathVariable("id") long id,
                        HttpServletRequest request, @ModelAttribute String errorMessage, Principal principal) {

        UserDto actualUser =  userService.findByEmailAddress(principal.getName());
        if(!hasActionPermission(actualUser, id)) {
            return new ModelAndView("redirect:/permissionViolation");
        }

        OccupationDto occupation = occupationService.findById(id);
        ModelAndView model = new ModelAndView("editOccupation");
        OccupationForm form = new OccupationForm();
        model.addObject("occupation", occupation);
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);
        return model;
    }

    @RequestMapping(value = "/editOccupation/{id}", method = RequestMethod.POST)
    public String editUserOccupationPost(@PathVariable("id") long id,
                                         @Valid @ModelAttribute("form") OccupationForm form,
                                     BindingResult result, RedirectAttributes redirectAttribute,
                                     HttpServletRequest request) {

        if (!result.hasErrors()) {
            occupationService.editOccupation(id, form);
            return "redirect:/occupations";
        }
        redirectAttribute.addFlashAttribute("errorMessage", "An error  occured: " + result.toString());
        return "redirect:/editOccupation/" + id;
    }

    @RequestMapping(value = "/admin/editOccupation/{id}", method = RequestMethod.GET)
    public ModelAndView editOccupationGet(@PathVariable("id") long id, Principal principal,
                                 HttpServletRequest request, @ModelAttribute String errorMessage) {

        if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
            return new ModelAndView("redirect:/permissionViolation");
        }

        ModelAndView model = new ModelAndView("admin/editOccupation");
        OccupationForm form = new OccupationForm();
        OccupationDto occupation = occupationService.findById(id);

        model.addObject("occupation", occupation);
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);
        return model;
    }

    @RequestMapping(value = "/admin/editOccupation/{id}", method = RequestMethod.POST)
    public String editOccupationPost(@PathVariable("id") long id,
                                     @Valid @ModelAttribute("form") OccupationForm form,
                           BindingResult result, RedirectAttributes redirectAttribute,
                           HttpServletRequest request) {

        if (!result.hasErrors()) {
            occupationService.editOccupation(id, form);
            return "redirect:/admin/occupations";
        }
        redirectAttribute.addFlashAttribute("errorMessage", "An error  occured: " + result.toString());
        return "redirect:/admin/editOccupation/" + id;
    }

    //TODO: Do this if occupation is selectable for users
    /*@RequestMapping(value = "/removeUserOccupation/{id}", method = RequestMethod.GET)
    public String removeUserOccupation(Principal principal, @PathVariable("id") long id) {
        occupationService.deleteUserOccupation(principal.getName(), id);
        return "redirect:/userOccupations";
    }*/

    @RequestMapping(value = "/deleteOccupation/{id}", method = RequestMethod.GET)
    public String deleteUserOccupation(Principal principal, @PathVariable("id") long id) {
        UserDto actualUser =  userService.findByEmailAddress(principal.getName());
        if(!hasActionPermission(actualUser, id)) {
            return "redirect:/permissionViolation";
        }

        occupationService.deleteOccupation(id);
        return "redirect:/occupations";
    }

    @RequestMapping(value = "/admin/deleteOccupation/{id}", method = RequestMethod.GET)
    public String deleteOccupation(@PathVariable("id") long id, Principal principal) {
        if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
            return "redirect:/permissionViolation";
        }
        occupationService.deleteOccupation(id);
        return "redirect:/admin/occupations";
    }

    //TODO: Maybe move out to a dedicateed class, maybe refactor/rename
    private boolean hasActionPermission(UserDto actualUser, long occupationId){
        List<OccupationDto> userOccupations = actualUser.getOccupations();
        for(OccupationDto occupation : userOccupations){
            if(occupation.getId() == occupationId){
                return true;
            }
        }
        return false;
    }


}
