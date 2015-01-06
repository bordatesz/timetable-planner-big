package hu.thesis.timetableplanner.repository;

import hu.thesis.timetableplanner.model.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccupationRepository extends JpaRepository<Occupation, Long> {

    Occupation findById(Long id);

    Occupation findByName(String name);

}
