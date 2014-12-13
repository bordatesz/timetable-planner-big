package hu.thesis.timetableplanner.authentication;

import hu.thesis.timetableplanner.authentication.LoginService;
import hu.thesis.timetableplanner.dto.AuthorityDto;
import hu.thesis.timetableplanner.dto.UserDto;
import hu.thesis.timetableplanner.model.Authority;
import hu.thesis.timetableplanner.repository.UserRepository;
import hu.thesis.timetableplanner.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * A custom {@link UserDetailsService} where user information
 * is retrieved from a JPA repository
 */
@Service
@Transactional(readOnly = true)
public class LoginService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	/**
	 * Returns a populated {@link UserDetails} object. 
	 * The username is first retrieved from the database and then mapped to 
	 * a {@link UserDetails} object.
	 */
	public UserDetails loadUserByUsername(String emailAdress) throws UsernameNotFoundException {
		
		UserDto user = userService.findByEmailAdress(emailAdress);
		List<AuthorityDto> authoritiesDto =  user.getAuthorities();
		
		if(authoritiesDto.isEmpty()){
			throw new UsernameNotFoundException("This user does not have authority to log in");
		}
		List<GrantedAuthority> authorities = buildAuthority(authoritiesDto);
				
		return buildAuthenticatedUser(user, authorities);
	}
	
	private List<GrantedAuthority> buildAuthority(List<AuthorityDto> authorities) {
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
		
		for (AuthorityDto authority : authorities) {
			
			result.add( new SimpleGrantedAuthority(authority.getAuthority()));
		}
		return result;
	}

	private UserDetails buildAuthenticatedUser(UserDto user,
			List<GrantedAuthority> authorities) {

		return new User(user.getEmailAdress(), user.getPassword(), true, true, true, true, authorities);
	}
	
}
