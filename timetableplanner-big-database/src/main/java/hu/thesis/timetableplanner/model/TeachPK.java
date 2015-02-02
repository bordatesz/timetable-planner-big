/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Atesz
 */
@Embeddable
public class TeachPK implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2581084557186375596L;

	@Column(name = "course", nullable=false)
    private Long course;

    @Column(name = "user", nullable=false)
    private Long user;

    public TeachPK() {
    }

    public TeachPK(Long course, Long user) {
        this.course = course;
        this.user = user;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeachPK)) {
            return false;
        }
        TeachPK other = (TeachPK) object;
        return this.course.equals(other.course) && this.user.equals(other.user);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.course != null ? this.course.hashCode() : 0);
        hash = 41 * hash + (this.user != null ? this.user.hashCode() : 0);
        return hash;
    }


    
}
