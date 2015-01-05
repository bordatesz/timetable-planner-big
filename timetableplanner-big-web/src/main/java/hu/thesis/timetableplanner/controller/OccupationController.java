package hu.thesis.timetableplanner.controller;

import hu.thesis.timetableplanner.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class OccupationController {

    @Autowired
    private OccupationService occupationService;


}
