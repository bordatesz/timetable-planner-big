package hu.thesis.timetableplanner.dto;

import java.util.List;

public class AuthorityDto extends BaseDto {

	private String authority;

	private List<UserDto> users;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

}