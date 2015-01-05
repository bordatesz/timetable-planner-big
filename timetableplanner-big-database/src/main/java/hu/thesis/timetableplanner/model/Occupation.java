/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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

	@ManyToMany(mappedBy = "occupations")
	private List<Lecturer> lecturers;

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

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setOktatokList(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

}
