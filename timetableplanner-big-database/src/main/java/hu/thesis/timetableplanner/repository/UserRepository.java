package hu.thesis.timetableplanner.repository;

import hu.thesis.timetableplanner.model.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(Long id);
	
	User findByEmailAdress(String emailAdress);
	
	User findByUserName(String userName);

	Page<User> findByLecturer(Boolean isLecturer, Pageable pageable);
}
