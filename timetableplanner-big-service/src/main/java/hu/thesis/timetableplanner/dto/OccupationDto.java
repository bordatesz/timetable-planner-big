package hu.thesis.timetableplanner.dto;

import java.util.Date;
import java.util.List;

public class OccupationDto extends BaseDto {

    private String name;

    private Date dateTime;

    private List<UserDto> lecturers;

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

    public List<UserDto> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<UserDto> lecturers) {
        this.lecturers = lecturers;
    }
}
