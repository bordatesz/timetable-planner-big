package hu.thesis.timetableplanner.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private String userName;

	@Column(unique = true)
	private String emailAdress;

	private String password;

	private Boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //ALL?
	@JoinTable(name = "user_authorities")
	private List<Authority> authorities;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
