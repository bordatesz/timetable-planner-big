package hu.thesis.timetableplanner.repository;

import hu.thesis.timetableplanner.model.OccupationGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Atesz on 2015.02.28..
 */
public interface OccupationGroupRepository extends JpaRepository<OccupationGroup, Long> {


    OccupationGroup findById(Long id);

    OccupationGroup findByName(String name);

}
