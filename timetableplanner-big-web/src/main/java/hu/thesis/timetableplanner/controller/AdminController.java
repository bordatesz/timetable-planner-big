package hu.thesis.timetableplanner.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import hu.thesis.timetableplanner.dto.AuthorityDto;
import hu.thesis.timetableplanner.dto.UserDto;
import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.form.CreateUserForm;
import hu.thesis.timetableplanner.form.EditUserForm;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.service.OccupationService;
import hu.thesis.timetableplanner.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private OccupationService occupationService;

	@InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	
	@RequestMapping(value = "/admin/createuser", method = RequestMethod.GET)
	public ModelAndView createUserGet(HttpServletRequest request,
			@ModelAttribute String errorMessage) {

		ModelAndView model = new ModelAndView("createUser");
		CreateUserForm form = new CreateUserForm();
		model.addObject("form", form);
		request.setAttribute("errorMessage", errorMessage);

		return model;
	}

	@RequestMapping(value = "/admin/createuser", method = RequestMethod.POST)
	public String createUserPost(HttpServletRequest request,
			@Valid @ModelAttribute("form") CreateUserForm form,
			BindingResult result, RedirectAttributes redirectAttributes) {

		boolean userExist = userService.checkUser(form.getEmailAdress());

		if (!result.hasErrors()) {
			if (!userExist) {
				userService.createUser(form);
				return "redirect:/admin/users/1";
			} else {
				redirectAttributes.addFlashAttribute("errorMessage",
						"This user is already exist");
				return "redirect:/admin/createuser";
			}
		}
		redirectAttributes.addFlashAttribute("errorMessage",
				"There is some error" + result.toString());
		return "redirect:/admin/createuser";

	}	

	@RequestMapping(value = "/admin/users/{pageNumber}", method = RequestMethod.GET)
	public ModelAndView listUsers(@PathVariable("pageNumber") int pageNumber,
			HttpServletRequest request) {
		ModelAndView model = new ModelAndView("adminUsersList");

		Pagination<UserDto> page = userService.findAllUserPageable(pageNumber);
		page.setPageName("/admin/users");
		model.addObject("page", page);

		return model;
	}
	
	@RequestMapping(value = "/admin/editUser/{id}", method = RequestMethod.GET)
	public ModelAndView editUserGet(@PathVariable("id") long id,

	HttpServletRequest request, @ModelAttribute String errorMessage) {

		ModelAndView model = new ModelAndView("editUser");
		EditUserForm editUser = new EditUserForm();
		UserDto user = userService.findById(id);
		
		for (AuthorityDto authority : user.getAuthorities()) {
            if(authority.getAuthority().equals("ROLE_ADMIN")){
                editUser.setAdmin(true);
            } else if(authority.getAuthority().equals("ROLE_LECTURER")){
				editUser.setLecturer(true);
			}
        }
		
		model.addObject("user", user);
		model.addObject("editUser", editUser);
		request.setAttribute("errorMessage", errorMessage);
		return model;
	}

	@RequestMapping(value = "/admin/editUser/{id}", method = RequestMethod.POST)
	public String editUserPost(@PathVariable("id") long id,
			@Valid @ModelAttribute("form") EditUserForm form,
			BindingResult result, RedirectAttributes redirectAttribute,
			HttpServletRequest request) {

		if (!result.hasErrors()) {
//			if ( (authenticationService.getUserId() == id) &&  (form.isAdmin() == false ) ) {
//				redirectAttribute.addFlashAttribute("errorMessage", "You can not change you own authority!");
//				return "redirect:/admin/editAuthor/" + id;
//			}else {
				if(form.getNewPassword() != null){
					userService.editUser(id, form, form.getNewPassword());
					return "redirect:/admin/users/1";
				}else{
					userService.editUser(id, form);
					return "redirect:/admin/users/1";
				}
//			}
		}
		redirectAttribute.addFlashAttribute("errorMessage", "An error  occured: " + result.toString());
		return "redirect:/admin/editUser/" + id;
	}

	@RequestMapping(value = "/admin/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") long id) {
		userService.deleteUser(id);
		return "redirect:/admin/users/1";
	}

	//TODO create occupation

}
