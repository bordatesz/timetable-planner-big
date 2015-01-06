package hu.thesis.timetableplanner.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import hu.thesis.timetableplanner.dto.UserDto;
import hu.thesis.timetableplanner.form.CreateUserForm;
import hu.thesis.timetableplanner.form.EditUserForm;
import hu.thesis.timetableplanner.model.User;
import hu.thesis.timetableplanner.model.Authority;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.repository.AuthorityRepository;
import hu.thesis.timetableplanner.repository.UserRepository;
import hu.thesis.timetableplanner.service.UserService;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private static final String SORT_BY_USER_NAME = "userName";
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Transactional
	@Override
	public long createUser(CreateUserForm form) {
		User newUser = new User();
		newUser.setUserName(form.getUserName());
		newUser.setEmailAdress(form.getEmailAdress());
		newUser.setPassword(form.getPassword());
		List<Authority> authorities = new ArrayList<Authority>();
		if (form.isAdmin()) {
			authorities.add(authorityRepository.findByAuthority("ROLE_ADMIN"));
		}
		if (form.isLecturer()) {
			authorities.add(authorityRepository.findByAuthority("ROLE_LECTURER"));
			newUser.setLecturer(true);
		}
		newUser.setAuthorities(authorities);
		return userRepository.save(newUser).getId();
	}

	@Transactional
	@Override
	public UserDto findByEmailAdress(String emailAdress) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		User user = userRepository.findByEmailAdress(emailAdress);
		return mapper.map(user, UserDto.class);
	}
	
	

	@Transactional
	@Override
	public Pagination<UserDto> findAllUserPageable(int pageNumber) {
		PageRequest page = new PageRequest(pageNumber - 1, Pagination.PAGE_SIZE, Sort.Direction.ASC, SORT_BY_USER_NAME);
		Page<User> userPage = userRepository.findAll(page);
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		List<UserDto> users = userPage.getContent().stream()
			.map((user) -> mapper.map(user, UserDto.class))
			.collect(Collectors.toList());
		return new Pagination<UserDto>(userPage, users);
	}

	@Override
	public Pagination<UserDto> findAllLecturerPageable(int pageNumber) {
		PageRequest page = new PageRequest(pageNumber - 1, Pagination.PAGE_SIZE, Sort.Direction.ASC, SORT_BY_USER_NAME);
		Page<User> userPage = userRepository.findByLecturer(true, page);
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		List<UserDto> users = userPage.getContent().stream()
				.map((user) -> mapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return new Pagination<UserDto>(userPage, users);
	}

	@Transactional
	@Override
	public boolean checkUser(String emailAdress) {
		User user = userRepository.findByEmailAdress(emailAdress);
		return user != null;
	}

	@Transactional
	@Override
	public UserDto findById(long id) {
		User user = userRepository.findOne(id);
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		return mapper.map(user, UserDto.class);
	}

	@Transactional
	@Override
	public boolean hasRole(long id, String role) {
		User user = userRepository.findOne(id);
		return user.getAuthorities().stream()
				.filter((authority) -> authority.getAuthority().equals(role))
				.findAny()
				.isPresent();
	}
	

	@Transactional
	@Override
	public void editUser(long id, EditUserForm form, String password) {	
		User user = userRepository.findOne(id);
		user.setUserName(form.getUserName());
		user.setPassword(password);
		if(form.isAdmin() && (hasRole(id, "ROLE_LECTURER") && !hasRole(id, "ROLE_ADMIN")) ){
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_ADMIN"));
		}else if(form.isLecturer() && (hasRole(id, "ROLE_ADMIN") && !hasRole(id, "ROLE_LECTURER")) ){
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_LECTURER"));
			user.setLecturer(form.isLecturer());
		} else if ((!form.isAdmin()) && hasRole(id, "ROLE_ADMIN")) {
			user.getAuthorities().remove(authorityRepository.findByAuthority("ROLE_ADMIN"));
		}else if(user.getAuthorities().isEmpty() && form.isAdmin()) {
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_ADMIN"));
		} else if (user.getAuthorities().isEmpty() && form.isLecturer()){
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_LECTURER"));
			user.setLecturer(form.isLecturer());
		}else if(user.getAuthorities().isEmpty() && form.isLecturer() && form.isAdmin()){
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_ADMIN"));
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_LECTURER"));
			user.setLecturer(form.isLecturer());
		}
		userRepository.save(user);
		
	}
	
	@Transactional
	@Override
	public void editUser(long id, EditUserForm form){
		User user = userRepository.getOne(id);
		user.setUserName(form.getUserName());
		if(form.isAdmin() && (hasRole(id, "ROLE_LECTURER") && !hasRole(id, "ROLE_ADMIN")) ){
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_ADMIN"));
		}else if(form.isLecturer() && (hasRole(id, "ROLE_ADMIN") && !hasRole(id, "ROLE_LECTURER")) ){
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_LECTURER"));
			user.setLecturer(form.isLecturer());
		} else if ((!form.isAdmin()) && hasRole(id, "ROLE_ADMIN")) {
			user.getAuthorities().remove(authorityRepository.findByAuthority("ROLE_ADMIN"));
		}else if(user.getAuthorities().isEmpty() && form.isAdmin()) {
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_ADMIN"));
		} else if (user.getAuthorities().isEmpty() && form.isLecturer()){
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_LECTURER"));
			user.setLecturer(form.isLecturer());
		}else if(user.getAuthorities().isEmpty() && form.isLecturer() && form.isAdmin()){
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_ADMIN"));
			user.getAuthorities().add(authorityRepository.findByAuthority("ROLE_LECTURER"));
			user.setLecturer(form.isLecturer());
		}
		userRepository.save(user);
	}
	
	@Transactional
	@Override
	public void deleteUser(long id){
		User user = userRepository.getOne(id);
		user.getAuthorities().clear();
		userRepository.save(user);
		userRepository.delete(user); //TODO FIX THIS
	}


}
