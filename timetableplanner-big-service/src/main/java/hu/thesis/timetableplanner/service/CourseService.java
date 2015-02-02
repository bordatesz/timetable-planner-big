package hu.thesis.timetableplanner.service;

import hu.thesis.timetableplanner.dto.CourseDto;

import java.util.List;

/**
 * Created by Atesz on 2015.01.08..
 */
public interface CourseService {

    public List<CourseDto> findAllUserCourse(String userEmail);
}
