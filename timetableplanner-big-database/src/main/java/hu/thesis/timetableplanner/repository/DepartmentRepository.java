package hu.thesis.timetableplanner.repository;

import hu.thesis.timetableplanner.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findById(Long id);

    Department findByName(String name);
}
