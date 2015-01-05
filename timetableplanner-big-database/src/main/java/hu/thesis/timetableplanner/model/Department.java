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
@Table(name = "department")
public class Department extends BaseEntity {

	@Column(length = 256, nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(referencedColumnName = "id", nullable = false)
	private Lecturer responsible;

	@OneToMany(mappedBy = "department")
	private List<Lecturer> lecturers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

}
