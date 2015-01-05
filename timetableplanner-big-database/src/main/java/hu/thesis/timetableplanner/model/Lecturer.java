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
@Table(name = "lecturer")
public class Lecturer extends BaseEntity {

	@Column(length = 64, nullable = false)
	private String name;

	@Column(length = 20, nullable = false)
	private String password;

	private Integer requiredHours;

	private Boolean active;

	private String roomNumber;

	@Column(length = 64)
	private String phoneNumber;

	private String email;

	@JoinTable(name = "occupied", joinColumns = { @JoinColumn(name = "lecturer", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "occupation", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Occupation> occupations;

	@JoinColumn(name = "department", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Department department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRequiredHours() {
		return requiredHours;
	}

	public void setRequiredHours(Integer requiredHours) {
		this.requiredHours = requiredHours;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
