package hu.thesis.timetableplanner.repository;

import hu.thesis.timetableplanner.model.Authority;
import hu.thesis.timetableplanner.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(Long id);
	
	User findByEmailAddress(String emailAddress);
	
	User findByUserName(String userName);

	List<User> findByAuthoritiesAuthority(String authority);

	Page<User> findByLecturer(Boolean isLecturer, Pageable pageable);
}
