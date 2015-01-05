package hu.thesis.timetableplanner.repository;

import hu.thesis.timetableplanner.model.Lecturer;
import hu.thesis.timetableplanner.model.Occupation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OccupationRepository extends JpaRepository<Occupation, Long> {

    Occupation findById(Long id);

    Occupation findByName(String name);

}
