package hu.thesis.timetableplanner.repository;


import hu.thesis.timetableplanner.model.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	
	Authority findByAuthority(String authority);

}
