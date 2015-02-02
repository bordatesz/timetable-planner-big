/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Atesz
 */
@Entity
@Table(name = "Teach")
public class Teach implements Serializable {
    
    private static final long serialVersionUID = 1581084557186375596L;
    
    @EmbeddedId
    protected TeachPK teachPK;
    
    @Column(name = "modifier_name", nullable=false)
    private String modifierName;

    @Column(name = "lecture_practice", nullable=false)
    private String lecturePractice;
    
    @Column(name = "more_course_code")
    private Integer moreCourseCode;
    
    @Column(name = "neptun")
    private Boolean neptun;

    @Column(name = "need_fulfillment", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date needFulfillment;
    
    @JoinColumn(referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    @JoinColumn(referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public Teach(){}

    public Teach(TeachPK teachPK) {
        this.teachPK = teachPK;
    }

    public Teach(TeachPK teachPK, String modifierName, String lecturePractice, Date needFulfillment) {
        this.teachPK = teachPK;
        this.modifierName = modifierName;
        this.lecturePractice = lecturePractice;
        this.needFulfillment = needFulfillment;
    }

    public Teach(Long course, Long lecturer) {
        this.teachPK = new TeachPK(course, lecturer);
    }

    public TeachPK getTeachPK() {
        return teachPK;
    }

    public void setTeachPK(TeachPK teachPK) {
        this.teachPK = teachPK;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public String getLecturePractice() {
        return lecturePractice;
    }

    public void setLecturePractice(String lecturePractice) {
        this.lecturePractice = lecturePractice;
    }

    public Integer getMoreCourseCode() {
        return moreCourseCode;
    }

    public void setMoreCourseCode(Integer moreCourseCode) {
        this.moreCourseCode = moreCourseCode;
    }

    public Boolean getNeptun() {
        return neptun;
    }

    public void setNeptun(Boolean neptun) {
        this.neptun = neptun;
    }

    public Date getNeedFulfillment() {
        return needFulfillment;
    }

    public void setNeedFulfillment(Date needFulfillment) {
        this.needFulfillment = needFulfillment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teachPK != null ? teachPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teach)) {
            return false;
        }
        Teach other = (Teach) object;
        if ((this.teachPK == null && other.teachPK != null) || (this.teachPK != null && !this.teachPK.equals(other.teachPK))) {
            return false;
        }
        return true;
    }
    
}
