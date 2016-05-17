package hu.thesis.timetableplanner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PermissionController {

	@RequestMapping(value="/permissionViolation" , method=RequestMethod.GET)
	public ModelAndView homePage(){
		ModelAndView model = new ModelAndView("permissionViolation");
		return model;
	}
}
