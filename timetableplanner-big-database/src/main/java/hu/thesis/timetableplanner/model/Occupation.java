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
@Table(name = "occupation")
public class Occupation extends BaseEntity {

	@Column(nullable = false)
	private String name;

	private String dateTime;

	@JoinTable(name = "occupied", joinColumns = {
			@JoinColumn(name = "occupation", referencedColumnName = "id")}, inverseJoinColumns = {
			@JoinColumn(name = "user", referencedColumnName = "id")})
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setOktatokList(List<User> lecturers) {
		this.users = lecturers;
	}

}
