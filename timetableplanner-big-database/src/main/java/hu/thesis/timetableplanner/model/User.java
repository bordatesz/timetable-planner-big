/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.model;

import java.util.List;

import javax.persistence.*;

/**
 *
 * @author Atesz
 */
@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private String userName;

	@Column(unique = true)
	private String emailAdress;

	private String password;

	private Boolean active;

	private Boolean lecturer;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL) //ALL?
	@JoinTable(name = "user_authorities")
	private List<Authority> authorities;

	private Integer requiredHours;

	private String roomNumber;

	@Column(length = 64)
	private String phoneNumber;

	@JoinTable(name = "occupied", joinColumns = { @JoinColumn(name = "lecturer", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "occupation", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Occupation> occupations;

	@JoinColumn(name = "department", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Department department;

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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getLecturer() {
		return lecturer;
	}

	public void setLecturer(Boolean lecturer) {
		this.lecturer = lecturer;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public Integer getRequiredHours() {
		return requiredHours;
	}

	public void setRequiredHours(Integer requiredHours) {
		this.requiredHours = requiredHours;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Occupation> getOccupations() {
		return occupations;
	}

	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


}
