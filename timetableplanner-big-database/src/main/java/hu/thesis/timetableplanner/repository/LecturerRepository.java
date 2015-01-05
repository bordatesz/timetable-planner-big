package hu.thesis.timetableplanner.repository;

import hu.thesis.timetableplanner.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

    Lecturer findById(Long id);

    Lecturer findByEmail(String email);

    Lecturer findByName(String name);
}
