/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.model;

import javax.persistence.*;
import java.util.List;

/**
 *
 * @author Atesz
 */
@Entity
@Table(name = "department")
public class Department extends BaseEntity {

	@Column(length = 256, nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private User timetableResponsible;

	@OneToMany(mappedBy = "department")
	private List<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getTimetableResponsible() {
		return timetableResponsible;
	}

	public void setTimetableResponsible(User timetableResponsible) {
		this.timetableResponsible = timetableResponsible;
	}

}
