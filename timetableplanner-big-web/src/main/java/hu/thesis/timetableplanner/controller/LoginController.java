package hu.thesis.timetableplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginPage(Principal principal) throws IllegalAccessException{
		ModelAndView loginModel = new ModelAndView("login");
		ModelAndView homeModel = new ModelAndView("redirect:/");

		if(principal != null){
			return homeModel;
		}
		return loginModel;
	}
}