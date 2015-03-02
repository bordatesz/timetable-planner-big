/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.model;

import java.util.Date;
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

	private Date dateTime;

	@JoinTable(name = "occupied", joinColumns = {
			@JoinColumn(name = "occupation", referencedColumnName = "id")}, inverseJoinColumns = {
			@JoinColumn(name = "user", referencedColumnName = "id")})
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<User> users;

    @JoinTable(name = "groupOccupied", joinColumns = {
            @JoinColumn(name = "occupation", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "occupationGroup", referencedColumnName = "id")})
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<OccupationGroup> occupationGroups;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

    public List<OccupationGroup> getOccupationGroups() {
        return occupationGroups;
    }

    public void setOccupationGroups(List<OccupationGroup> occupationGroups) {
        this.occupationGroups = occupationGroups;
    }
}
