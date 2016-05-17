package hu.thesis.timetableplanner.service.impl;

import hu.thesis.timetableplanner.dto.CourseDto;
import hu.thesis.timetableplanner.form.CourseForm;
import hu.thesis.timetableplanner.model.Course;
import hu.thesis.timetableplanner.model.Teach;
import hu.thesis.timetableplanner.model.User;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.repository.CourseRepository;
import hu.thesis.timetableplanner.repository.TeachRepository;
import hu.thesis.timetableplanner.repository.UserRepository;
import hu.thesis.timetableplanner.service.CourseService;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    private static final String SORT_BY_CURRICULA = "curricula";

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeachRepository teachRepository;

    @Transactional
    @Override
    public CourseDto findById(long id) {
        Course course = courseRepository.findOne(id);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        return mapper.map(course, CourseDto.class);
    }

    @Transactional
    @Override
    public List<CourseDto> findAllCourse() {
        List<Course> courseEntites = courseRepository.findAll();
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        List<CourseDto> courses = courseEntites.stream()
                .map((course) -> mapper.map(course, CourseDto.class))
                .collect(Collectors.toList());
        return courses;
    }

    @Transactional
    @Override
    public Pagination<CourseDto> findAllCoursePageable(int pageNumber) {
        PageRequest page = new PageRequest(pageNumber - 1, Pagination.PAGE_SIZE, Sort.Direction.ASC, SORT_BY_CURRICULA);
        Page<Course> coursePage = courseRepository.findAll(page);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        List<CourseDto> courses = new ArrayList<CourseDto>();

        for (Course course : coursePage.getContent()) {
            courses.add(mapper.map(course, CourseDto.class));
        }

        return new Pagination<CourseDto>(coursePage, courses);
    }

    @Transactional
    @Override
    public Long createCourse(CourseForm form) {
        Course newCourse = new Course();
        newCourse.setName(form.getName());
        newCourse.setCredit(form.getCredit());
        newCourse.setCurricula(form.getCurricula());
        newCourse.setHoursPerWeek(form.getHoursPerWeek());
        newCourse.setPeriod(form.getPeriod());
        newCourse.setType(form.getType());
        if(!form.getResponsible().equals("")) {
            User responsible = userRepository.findByEmailAddress(form.getResponsible());
            newCourse.setResponsible(responsible);
        }
        return courseRepository.save(newCourse).getId();
    }

    @Transactional
    @Override
    public void editCourse(long id, CourseForm form) {
        Course course = courseRepository.findOne(id);
        course.setName(form.getName());
        course.setCredit(form.getCredit());
        course.setCurricula(form.getCurricula());
        course.setHoursPerWeek(form.getHoursPerWeek());
        course.setPeriod(form.getPeriod());
        course.setType(form.getType());
        User responsible = userRepository.findByEmailAddress(form.getResponsible());
        course.setResponsible(responsible);
        courseRepository.save(course).getId();
    }

    //TODO majd lehet a teach-nél is törölni kell!!!!!!!!
    @Transactional
    @Override
    public void deleteCourse(long id) {
        Course course = courseRepository.getOne(id);
        courseRepository.delete(course);

    }

    @Transactional
    @Override
    public boolean checkCourse(String name, Integer curricula, Integer period) {
        Course course = courseRepository.findByNameAndCurriculaAndPeriod(name, curricula, period);
        return course != null;
    }

    @Transactional
    @Override
    public List<CourseDto> findByResponsibleEmailAddress(String responsibleEmailAddress){
        List<Course> courses = courseRepository.findByResponsibleEmailAddress(responsibleEmailAddress);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        List<CourseDto> userResponsibilities = new ArrayList<CourseDto>();
        for (Course course : courses) {
            userResponsibilities.add(mapper.map(course, CourseDto.class));
        }
        return userResponsibilities;
    }

    //TODO: Ez inkább a teach hez tartozik majd... az oktató milyen tantárgyakat kapott
    @Transactional
    @Override
    public List<CourseDto> findAllUserCourse(String userEmail) {

        User user = userRepository.findByEmailAddress(userEmail);
        List<Teach> taught = teachRepository.findByUser(user);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        List<CourseDto> userCourses = new ArrayList<CourseDto>();

        for (Teach teach : taught) {
            userCourses.add(mapper.map(teach.getCourse(), CourseDto.class));
        }

        return userCourses;
    }
}
