package hu.thesis.timetableplanner.controller;

import hu.thesis.timetableplanner.dto.LecturerDto;
import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.model.Lecturer;
import hu.thesis.timetableplanner.model.Occupation;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.service.LecturerService;
import hu.thesis.timetableplanner.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class LecturerController {

    @Autowired
    private LecturerService lecturerService;

    @RequestMapping(value = "/lecturers/{pageNumber}", method = RequestMethod.GET)
    public ModelAndView listLecturers(@PathVariable("pageNumber") int pageNumber,
                                  HttpServletRequest request) {
        ModelAndView model = new ModelAndView("adminLecturerList");

        Pagination<LecturerDto> page = lecturerService.findAllLecturerPageable(pageNumber);
        page.setPageName("/admin/lecturers");
        model.addObject("page", page);

        return model;
    }

    @RequestMapping(value = "/lecturerOccupation/{id}",method = RequestMethod.GET)
    public ModelAndView listLecturerOccupation(@PathVariable("id") long id, HttpServletRequest request) {

        ModelAndView model = new ModelAndView("adminLecturerOccupation");

        LecturerDto lecturer = lecturerService.findById(id);
        List<OccupationDto> occupations = lecturer.getOccupations();
        model.addObject("occupations", occupations);

        return model;
    }
}
