package hu.thesis.timetableplanner.service;

import hu.thesis.timetableplanner.dto.CourseDto;
import hu.thesis.timetableplanner.form.CourseForm;
import hu.thesis.timetableplanner.pagination.Pagination;

import java.util.List;

public interface CourseService {

    public CourseDto findById(long id);

    public Pagination<CourseDto> findAllCoursePageable(int pageNumber);

    public List<CourseDto> findAllCourse();

    public Long createCourse(CourseForm form);

    public void editCourse(long id, CourseForm form);

    public void deleteCourse(long id);

    public List<CourseDto> findAllUserCourse(String userEmail);

    public boolean checkCourse(String name, Integer curricula, Integer period);

    List<CourseDto> findByResponsibleEmailAddress(String responsibleEmailAddress);

}
