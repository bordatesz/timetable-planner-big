package hu.thesis.timetableplanner.controller;

import hu.thesis.timetableplanner.dto.OccupationGroupDto;
import hu.thesis.timetableplanner.form.OccupationGroupForm;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.service.OccupationGroupService;
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

@Controller
public class OccupationGroupController {

    @Autowired
    private OccupationGroupService occupationGroupService;

    @RequestMapping(value = "/admin/occupationGroups/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView listOccupationGroups(@PathVariable("pageNumber") int pageNumber,
                                             HttpServletRequest request) {
        ModelAndView model = new ModelAndView("admin/occupationGroupsList");

        Pagination<OccupationGroupDto> page = occupationGroupService.findAllOccupationGroupPageable(pageNumber);
        page.setPageName("admin/occupationGroups");
        model.addObject("page", page);

        return model;
    }

    @RequestMapping(value = "/admin/deleteOccupationGroup/{id}", method = RequestMethod.GET)
    public String deleteOccupationGroup(@PathVariable("id") long id) {
        occupationGroupService.deleteOccupationGroup(id);
        return "redirect:/admin/occupationGroups/1";
    }

    @RequestMapping(value = "/admin/createOccupationGroup", method = RequestMethod.GET)
    public ModelAndView createOccupationGroupGet(HttpServletRequest request,
                                                 @ModelAttribute String errorMessage) {

        ModelAndView model = new ModelAndView("admin/createOccupationGroup");
        OccupationGroupForm form = new OccupationGroupForm();
        model.addObject("form", form);
        request.setAttribute("errorMessage", errorMessage);

        return model;
    }

    @RequestMapping(value = "/admin/createOccupationGroup", method = RequestMethod.POST)
    public String createOccupationGroupPost(HttpServletRequest request,
                                            @Valid @ModelAttribute("form") OccupationGroupForm form,
                                            BindingResult result, RedirectAttributes redirectAttributes) {
        if (!result.hasErrors()) {
            occupationGroupService.createOccupationGroup(form);
            return "redirect:/admin/occupationGroups/1";
        }
        redirectAttributes.addFlashAttribute("errorMessage",
                "There is some error" + result.toString());
        return "redirect:/admin/createOccupationGroup";

    }
}
