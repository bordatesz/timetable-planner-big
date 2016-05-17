package hu.thesis.timetableplanner.form;

import hu.thesis.timetableplanner.model.Teach;
import hu.thesis.timetableplanner.model.User;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class CourseForm {

    @NotNull
    @Size(min=1,max=255)
    private String name;

    @NotNull
    @Size(min=1,max=255)
    private String type;

    @NotNull
    private Integer credit;

    private Integer hoursPerWeek;

    private Integer period;

    private Integer curricula;

    private String responsible;

    //private List<Teach> taughtBy;

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

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    /*public List<Teach> getTaughtBy() {
        return taughtBy;
    }*/

    /*public void setTaughtBy(List<Teach> taughtBy) {
        this.taughtBy = taughtBy;
    } */
}
