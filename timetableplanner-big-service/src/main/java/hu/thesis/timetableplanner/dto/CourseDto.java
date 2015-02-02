package hu.thesis.timetableplanner.dto;

import hu.thesis.timetableplanner.model.Teach;
import hu.thesis.timetableplanner.model.User;

import java.util.List;

/**
 * Created by Atesz on 2015.01.08..
 */
public class CourseDto extends BaseDto {

    private String name;

    private String type;

    private Integer credit;

    private Integer hoursPerWeek;

    private Integer period;

    private Integer curricula;

    private User responsible;

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

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
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

    public User getResponsible() {
        return responsible;
    }

    public void setResponsible(User responsible) {
        this.responsible = responsible;
    }

    public List<Teach> getTaughtBy() {
        return taughtBy;
    }

    public void setTaughtBy(List<Teach> taughtBy) {
        this.taughtBy = taughtBy;
    }
}
