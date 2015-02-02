package hu.thesis.timetableplanner.repository;

import hu.thesis.timetableplanner.model.Teach;
import hu.thesis.timetableplanner.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Atesz on 2015.01.08..
 */
public interface TeachRepository extends JpaRepository<Teach, Long> {

    List<Teach> findByUser(User user);
}
