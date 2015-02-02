package hu.thesis.timetableplanner.controller;

import hu.thesis.timetableplanner.dto.CourseDto;
import hu.thesis.timetableplanner.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/userCourses", method = RequestMethod.GET) //TODO pageable?
    public ModelAndView listUserCourses(Principal principal, HttpServletRequest request) {
        ModelAndView model = new ModelAndView("userCourseList");

        String actualUser =  principal.getName();
        List<CourseDto> userCourses = courseService.findAllUserCourse(actualUser);

        model.addObject("userCourses", userCourses);

        return model;
    }
}
