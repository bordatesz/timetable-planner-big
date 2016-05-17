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
@Table(name = "Course")
public class Course extends BaseEntity {

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String type;

    @Column(nullable=false)
    private Integer credit;

    private Integer hoursPerWeek;

    private Integer period;

    private Integer curricula;

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne
    private User responsible;
    
    @OneToMany(mappedBy = "course")
    private List<Teach> taughtBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getCurricula() {
        return curricula;
    }

    public void setCurricula(Integer curricula) {
        this.curricula = curricula;
    }

    public List<Teach> getTaughtBy() {
        return taughtBy;
    }

    public void setTaughtBy(List<Teach> taughtBy) {
        this.taughtBy = taughtBy;
    }

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }
    
}
