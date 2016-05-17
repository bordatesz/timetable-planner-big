package hu.thesis.timetableplanner.service.impl;

import hu.thesis.timetableplanner.dto.UserDto;
import hu.thesis.timetableplanner.form.CreateUserForm;
import hu.thesis.timetableplanner.form.EditUserForm;
import hu.thesis.timetableplanner.model.Authority;
import hu.thesis.timetableplanner.model.User;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		newUser.setEmailAddress(form.getEmailAddress());
		newUser.setPassword(form.getPassword());
		List<Authority> authorities = new ArrayList<Authority>();
		for(String role : form.getUserRoles()){
			authorities.add(authorityRepository.findByAuthority(role));
		}
		newUser.setAuthorities(authorities);
		return userRepository.save(newUser).getId();
	}

	@Transactional
	@Override
	public UserDto findByEmailAddress(String emailAddress) {
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		User user = userRepository.findByEmailAddress(emailAddress);
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

	@Transactional
	@Override
	public List<UserDto> findAllUser() {
		List<User> userEntites = userRepository.findAll();
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		List<UserDto> users = userEntites.stream()
				.map((user) -> mapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return users;
	}

    //TODO: Why do I need this??
    /*@Transactional
	@Override
	public Pagination<UserDto> findAllLecturerPageable(int pageNumber) {
		PageRequest page = new PageRequest(pageNumber - 1, Pagination.PAGE_SIZE, Sort.Direction.ASC, SORT_BY_USER_NAME);
		Page<User> userPage = userRepository.findByLecturer(true, page);
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		List<UserDto> users = userPage.getContent().stream()
				.map((user) -> mapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return new Pagination<UserDto>(userPage, users);
	}*/

	@Transactional
	@Override
	public boolean checkUser(String emailAddress) {
		User user = userRepository.findByEmailAddress(emailAddress);
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
	public boolean hasRoleByEmailAddress(String emailAddress, String role){
		User user = userRepository.findByEmailAddress(emailAddress);
		return user.getAuthorities().stream()
				.filter((authority) -> authority.getAuthority().equals(role))
				.findAny()
				.isPresent();
	}
	

	@Transactional
	@Override
	public void editUser(long id, EditUserForm form, String password) {	
		User user = updateUser(id, form);
		user.setPassword(password);
		userRepository.save(user);
		
	}
	
	@Transactional
	@Override
	public void editUser(long id, EditUserForm form){
		User user = updateUser(id, form);
		userRepository.save(user);
	}

	private User updateUser(long userId, EditUserForm form) {
		User user = userRepository.getOne(userId);
		user.setUserName(form.getUserName());
		//TODO: Refactor :D A lecturer talán hardcoded kéne, hogy deafult legyen
		user.getAuthorities().clear();
		userRepository.save(user);
		for(String role : form.getUserRoles()){
			user.getAuthorities().add(authorityRepository.findByAuthority(role));
		}
		return user;
	}
	
	@Transactional
	@Override
	public void deleteUser(long id){
		User user = userRepository.getOne(id);
		userRepository.delete(user);
	}

	@Transactional
	@Override
	public List<UserDto> findByAuthorityName(String authorityName) {
		List<User> usersWithAuthority = userRepository.findByAuthoritiesAuthority(authorityName);
		Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
		List<UserDto> users = usersWithAuthority.stream()
				.map((user) -> mapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		return users;
	}
}
