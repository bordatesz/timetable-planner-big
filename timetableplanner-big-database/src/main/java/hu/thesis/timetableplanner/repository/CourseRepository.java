package hu.thesis.timetableplanner.repository;

import hu.thesis.timetableplanner.model.Course;
import hu.thesis.timetableplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Atesz on 2015.01.08..
 */
public interface CourseRepository  extends JpaRepository<Course, Long> {

    Course findById(Long id);

    Course findByName(String name);

    List<Course> findByResponsibleEmailAddress(String responsibleEmailAddress);

    //TODO: Ezekre nincs valami isexist vagy ilyesmi string reposiotyban hogy booleannel térjen vissza?
    Course findByNameAndCurriculaAndPeriod(String name, Integer curricula, Integer period);

    //List<Course> findByTeachUser(User user);
}
