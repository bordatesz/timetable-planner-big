package hu.thesis.timetableplanner.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "authority")
public class Authority extends BaseEntity {

	private String authority;

	@ManyToMany(mappedBy = "authorities")
	private List<User> users;

	public List<User> getUser() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
