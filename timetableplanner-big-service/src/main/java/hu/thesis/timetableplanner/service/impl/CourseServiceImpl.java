package hu.thesis.timetableplanner.service.impl;

import hu.thesis.timetableplanner.dto.CourseDto;
import hu.thesis.timetableplanner.model.Course;
import hu.thesis.timetableplanner.model.Teach;
import hu.thesis.timetableplanner.model.User;
import hu.thesis.timetableplanner.repository.CourseRepository;
import hu.thesis.timetableplanner.repository.TeachRepository;
import hu.thesis.timetableplanner.repository.UserRepository;
import hu.thesis.timetableplanner.service.CourseService;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeachRepository teachRepository;

    @Transactional
    @Override
    public List<CourseDto> findAllUserCourse(String userEmail) {

        User user = userRepository.findByEmailAdress(userEmail);
        List<Teach> taught = teachRepository.findByUser(user);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        List<CourseDto> userCourses = new ArrayList<CourseDto>();

        for (Teach teach : taught) {
            userCourses.add(mapper.map(teach.getCourse(), CourseDto.class));
        }

        return userCourses;
    }
}
