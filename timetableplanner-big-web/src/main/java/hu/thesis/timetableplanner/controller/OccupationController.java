package hu.thesis.timetableplanner.controller;

import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.dto.UserDto;
import hu.thesis.timetableplanner.form.OccupationForm;
import hu.thesis.timetableplanner.model.Occupation;
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

    @RequestMapping(value = "/userOccupations", method = RequestMethod.GET) //TODO pageable?
    public ModelAndView listUserOccupations(Principal principal, HttpServletRequest request) {
        ModelAndView model = new ModelAndView("userOccupationList");

        UserDto actualUser =  userService.findByEmailAdress(principal.getName());
        List<OccupationDto> userOccupations = actualUser.getOccupations();

        model.addObject("userOccupations", userOccupations);

        return model;
    }

    @RequestMapping(value = "/admin/occupations/{pageNumber}", method = RequestMethod.GET) //TODO pageable?
    public ModelAndView listOccupations(@PathVariable("pageNumber") int pageNumber, HttpServletRequest request) {
        ModelAndView model = new ModelAndView("admin/occupationList");

        Pagination<OccupationDto> page = occupationService.findAllOccupationPageable(pageNumber);
        page.setPageName("/admin/occupations");
        model.addObject("page", page);

        return model;
    }

    @RequestMapping(value = "/addUserOccupation", method = RequestMethod.GET)
    public ModelAndView createUserOccupationGet(HttpServletRequest request,
                                      @ModelAttribute String errorMessage) {

        ModelAndView model = new ModelAndView("createUserOccupation");
        OccupationForm form = new OccupationForm();
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);

        return model;
    }

    @RequestMapping(value = "/addUserOccupation", method = RequestMethod.POST)
    public String createUserOccupationPost(Principal principal, HttpServletRequest request,
                                           @Valid @ModelAttribute("form") OccupationForm form,
                                 BindingResult result, RedirectAttributes redirectAttributes) {
        if (!result.hasErrors()) {
            occupationService.createUserOccupation(principal.getName(), form);
            return "redirect:/userOccupations";
        }
        redirectAttributes.addFlashAttribute("errorMessage",
                "There is some error" + result.toString());
        return "redirect:/addUserOccupation";

    }

    @RequestMapping(value = "/admin/addOccupation", method = RequestMethod.GET)
    public ModelAndView createOccupationGet(HttpServletRequest request,
                                                @ModelAttribute String errorMessage) {

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

    @RequestMapping(value = "/editUserOccupation/{id}", method = RequestMethod.GET)
    public ModelAndView editUserOccupationGet(@PathVariable("id") long id,
                                          HttpServletRequest request, @ModelAttribute String errorMessage) {

        ModelAndView model = new ModelAndView("editOccupation");
        OccupationForm form = new OccupationForm();
        OccupationDto occupation = occupationService.findById(id); //USert le kell kérni, és ellenőrzni hogy hozzá tartozik e

        model.addObject("occupation", occupation);
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);
        return model;
    }

    @RequestMapping(value = "/editUserOccupation/{id}", method = RequestMethod.POST)
    public String editUserOccupationPost(@PathVariable("id") long id,
                                         @Valid @ModelAttribute("form") OccupationForm form,
                                     BindingResult result, RedirectAttributes redirectAttribute,
                                     HttpServletRequest request) {

        if (!result.hasErrors()) {
            occupationService.editOccupation(id, form);
            return "redirect:/userOccupations";
        }
        redirectAttribute.addFlashAttribute("errorMessage", "An error  occured: " + result.toString());
        return "redirect:/editUserOccupation/" + id;
    }

    //TODO Ez felesleges, mert ha egy metódussal (GET/POST) ROLE-t ellenőrizve szerveroldalon ellenőrzöm, akkor elég egy
    //TODO: Here is the method you should use for checking the user role: "public boolean hasRole(long id, String role)"
    @RequestMapping(value = "/admin/editOccupation/{id}", method = RequestMethod.GET)
    public ModelAndView editOccupationGet(@PathVariable("id") long id,
                                 HttpServletRequest request, @ModelAttribute String errorMessage) {

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
            return "redirect:/admin/occupations/1";
        }
        redirectAttribute.addFlashAttribute("errorMessage", "An error  occured: " + result.toString());
        return "redirect:/admin/editOccupation/" + id;
    }

    @RequestMapping(value = "/removeUserOccupation/{id}", method = RequestMethod.GET)  //alias remove
    public String removeUserOccupation(Principal principal, @PathVariable("id") long id) {
        occupationService.deleteUserOccupation(principal.getName(), id);
        return "redirect:/userOccupations";
    }

    @RequestMapping(value = "/deleteUserOccupation/{id}", method = RequestMethod.GET)  //alias remove
    public String deleteUserOccupation(Principal principal, @PathVariable("id") long id) {
        occupationService.deleteOccupation(id);
        return "redirect:/userOccupations";
    }

    @RequestMapping(value = "/admin/deleteOccupation/{id}", method = RequestMethod.GET)
    public String deleteOccupation(@PathVariable("id") long id) {
        occupationService.deleteOccupation(id);
        return "redirect:/occupations/1";
    }


}
