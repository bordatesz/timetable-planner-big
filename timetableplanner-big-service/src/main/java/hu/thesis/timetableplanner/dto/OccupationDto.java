package hu.thesis.timetableplanner.dto;

import java.util.List;

public class OccupationDto extends BaseDto {

    private String name;

    private String dateTime;

    private List<LecturerDto> lecturers;

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

    public List<LecturerDto> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<LecturerDto> lecturers) {
        this.lecturers = lecturers;
    }
}
