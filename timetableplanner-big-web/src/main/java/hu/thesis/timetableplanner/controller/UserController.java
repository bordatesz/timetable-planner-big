package hu.thesis.timetableplanner.controller;

import hu.thesis.timetableplanner.dto.AuthorityDto;
import hu.thesis.timetableplanner.dto.UserDto;
import hu.thesis.timetableplanner.form.CreateUserForm;
import hu.thesis.timetableplanner.form.EditUserForm;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.service.AuthorityService;
import hu.thesis.timetableplanner.service.OccupationService;
import hu.thesis.timetableplanner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

    @Autowired
    private AuthorityService authorityService;

	@Autowired
	private OccupationService occupationService;


	@InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	
	@RequestMapping(value = "/admin/createUser", method = RequestMethod.GET)
	public ModelAndView createUserGet(HttpServletRequest request,
			@ModelAttribute String errorMessage, Principal principal) {

		if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
			return new ModelAndView("redirect:/permissionViolation");
		}

		ModelAndView model = new ModelAndView("admin/createUser");
		CreateUserForm form = new CreateUserForm();
        List<AuthorityDto> roles = authorityService.findAllAuthority();
        model.addObject("roles", roles);
		model.addObject("form", form);
		request.setAttribute("errorMessage", errorMessage);

		return model;
	}

	@RequestMapping(value = "/admin/createUser", method = RequestMethod.POST)
	public String createUserPost(HttpServletRequest request,
			@Valid @ModelAttribute("form") CreateUserForm form,
			BindingResult result, RedirectAttributes redirectAttributes) {

		boolean userExist = userService.checkUser(form.getEmailAddress());

		if (!result.hasErrors()) {
			if (!userExist) {
				userService.createUser(form);
				return "redirect:/admin/users/1";
			} else {
				redirectAttributes.addFlashAttribute("errorMessage",
						"This user is already exist");
				return "redirect:/admin/createUser";
			}
		}
		redirectAttributes.addFlashAttribute("errorMessage",
				"There is some error" + result.toString());
		return "redirect:/admin/createUser";

	}

	@RequestMapping(value = "/admin/users/{pageNumber}", method = RequestMethod.GET)
	public ModelAndView listUsers(@PathVariable("pageNumber") int pageNumber,
								  HttpServletRequest request, Principal principal) {

		if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
			return new ModelAndView("redirect:/permissionViolation");
		}

		ModelAndView model = new ModelAndView("admin/usersList");
		Pagination<UserDto> page = userService.findAllUserPageable(pageNumber);
		page.setPageName("admin/users");
		model.addObject("page", page);

		return model;
	}
	
	@RequestMapping(value = "/admin/editUser/{id}", method = RequestMethod.GET)
	public ModelAndView editUserGet(@PathVariable("id") long id,
	HttpServletRequest request, @ModelAttribute String errorMessage, Principal principal) {

		if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
			return new ModelAndView("redirect:/permissionViolation");
		}

		ModelAndView model = new ModelAndView("admin/editUser");
		EditUserForm form = new EditUserForm();
		UserDto user = userService.findById(id);
        List<AuthorityDto> roles = authorityService.findAllAuthority();

		List<String> userRoleNames = new ArrayList<>();
		for(AuthorityDto userRole : user.getAuthorities()){
			userRoleNames.add(userRole.getAuthority());
		}
		form.setUserRoles(userRoleNames);

		//TODO: USer feltöltése minden role-al itt kéne?
		model.addObject("user", user);
        model.addObject("roles", roles);
		model.addObject("form", form);
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
	public String deleteUser(@PathVariable("id") long id, Principal principal) {

		if(!userService.hasRoleByEmailAddress(principal.getName(), "ROLE_SYS_ADMIN")) {
			return "redirect:/permissionViolation";
		}

		userService.deleteUser(id);
		return "redirect:/admin/users/1";
	}


}
