package hu.thesis.timetableplanner.controller;

import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.dto.UserDto;
import hu.thesis.timetableplanner.form.OccupationForm;
import hu.thesis.timetableplanner.model.Occupation;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.service.OccupationService;
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
public class OccupationController {

    @Autowired
    private OccupationService occupationService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userOccupations", method = RequestMethod.GET) //TODO pageable?
    public ModelAndView listUserOccupations(Principal principal, HttpServletRequest request) {
        ModelAndView model = new ModelAndView("userOccupationList");

        UserDto actualUser =  userService.findByEmailAdress(principal.getName());
        List<OccupationDto> userOccupations = actualUser.getOccupations();

        model.addObject("userOccupations", userOccupations);

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

    @RequestMapping(value = "/addOccupation", method = RequestMethod.GET)
    public ModelAndView createOccupationGet(HttpServletRequest request,
                                                @ModelAttribute String errorMessage) {

        ModelAndView model = new ModelAndView("createOccupation");
        OccupationForm form = new OccupationForm();
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);

        return model;
    }

    @RequestMapping(value = "/addOccupation", method = RequestMethod.POST)
    public String createOccupationPost(HttpServletRequest request,
                                 @Valid @ModelAttribute("form") OccupationForm form,
                                 BindingResult result, RedirectAttributes redirectAttributes) {
        if (!result.hasErrors()) {
            occupationService.createOccupation(form);
            return "redirect:/occupations/1";
        }
        redirectAttributes.addFlashAttribute("errorMessage",
                "There is some error" + result.toString());
        return "redirect:/addOccupation";

    }

    @RequestMapping(value = "/editUserOccupation/{id}", method = RequestMethod.GET)
    public ModelAndView editUserOccupationGet(@PathVariable("id") long id,
                                          HttpServletRequest request, @ModelAttribute String errorMessage) {

        ModelAndView model = new ModelAndView("editOccupation");
        OccupationForm form = new OccupationForm();
        OccupationDto occupation = occupationService.findById(id);

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

    @RequestMapping(value = "/editOccupation/{id}", method = RequestMethod.GET)
    public ModelAndView editOccupationGet(@PathVariable("id") long id,
                                 HttpServletRequest request, @ModelAttribute String errorMessage) {

        ModelAndView model = new ModelAndView("editOccupation");
        OccupationForm form = new OccupationForm();
        OccupationDto occupation = occupationService.findById(id);

        model.addObject("occupation", occupation);
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);
        return model;
    }

    @RequestMapping(value = "/editOccupation/{id}", method = RequestMethod.POST)
    public String editOccupationPost(@PathVariable("id") long id,
                                     @Valid @ModelAttribute("form") OccupationForm form,
                           BindingResult result, RedirectAttributes redirectAttribute,
                           HttpServletRequest request) {

        if (!result.hasErrors()) {
            occupationService.editOccupation(id, form);
            return "redirect:/occupations/1";
        }
        redirectAttribute.addFlashAttribute("errorMessage", "An error  occured: " + result.toString());
        return "redirect:/editOccupation/" + id;
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

    @RequestMapping(value = "/deleteOccupation/{id}", method = RequestMethod.GET)
    public String deleteOccupation(@PathVariable("id") long id) {
        occupationService.deleteOccupation(id);
        return "redirect:/occupations/1";
    }


}
