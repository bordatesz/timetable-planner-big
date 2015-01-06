package hu.thesis.timetableplanner.dto;

import java.util.List;

public class OccupationDto extends BaseDto {

    private String name;

    private String dateTime;

    private List<UserDto> lecturers;

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

    public List<UserDto> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<UserDto> lecturers) {
        this.lecturers = lecturers;
    }
}
