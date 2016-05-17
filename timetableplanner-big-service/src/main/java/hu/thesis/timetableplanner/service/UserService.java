package hu.thesis.timetableplanner.service;

import hu.thesis.timetableplanner.dto.AuthorityDto;
import hu.thesis.timetableplanner.dto.UserDto;
import hu.thesis.timetableplanner.form.CreateUserForm;
import hu.thesis.timetableplanner.form.EditUserForm;
import hu.thesis.timetableplanner.pagination.Pagination;

import java.util.List;

public interface UserService {
	
	/**
	 * Create a new User, with the given password.
	 * @param form
	 * @return The id of the created User.
	 */
	long createUser(CreateUserForm form);
	
	/**
	 * Find a user by its email address which has to be identical.
	 * @param emailAddress
	 * @return UserDto
	 */
	UserDto findByEmailAddress(String emailAddress);
	
	/**
	 * Check the user if already exist.
	 * @param emailAddress
	 * @return boolean
	 */
	boolean checkUser(String emailAddress);
	
	/**
	 * Returns all the created user
	 * in a page.
	 * @param pageNumber
	 * @return @{link Pagination<UserDto>}
	 */
	
	Pagination<UserDto> findAllUserPageable(int pageNumber);

	/**
	 * Returns all the created user
	 * @return @{link Pagination<UserDto>}
	 */

	List<UserDto> findAllUser();

	/**
	 * Returns all the created user having author authority
	 * in a page.
	 * @param pageNumber
	 * @return @{link Pagination<UserDto>}
	 */

	//Pagination<UserDto> findAllLecturerPageable(int pageNumber);
	

	/**
	 * Find a user with the given id and return with 
	 * user dto
	 * @param id
	 * @return {@link UserDto}
	 */
	UserDto findById(long id);
	
	
	/**
	 * Update the modification mad on the given user 
	 * and i modify its password!
	 * @param id is the identifier of the user being edited
	 * @param form is the Edit form.
	 */
	void editUser(long id, EditUserForm form, String password);
	
	/**
	 * Update the modification mad on the given user 
	 * but i won't modify its password!
	 * @param id is the identifier of the user being edited
	 * @param form is the Edit form.
	 */
	void editUser(long id, EditUserForm form);
	
	/**
	 * It checks wheather the user has a role provided as parameter and
	 * return true if it has or false otherwise.
	 * @param id is the identifier of the user
	 * @param role is the role that being checked 
	 * @return {@link boolean}
	 */
	boolean hasRole(long id, String role);

	/**
	 * It checks wheather the user find by email address has a role provided as parameter and
	 * return true if it has or false otherwise.
	 * @param emailAddress is the identifier of the user
	 * @param role is the role that being checked
	 * @return {@link boolean}
	 */
	boolean hasRoleByEmailAddress(String emailAddress, String role);
	
	/**
	 * It virtualy deletes the user, after this the 
	 * user doesn't have aouthortiy to log in although
	 * non of the users post will removed or setted to invisible.   
	 * @param id 
	 */
	void deleteUser(long id);

	List<UserDto> findByAuthorityName(String authorityName);

}
