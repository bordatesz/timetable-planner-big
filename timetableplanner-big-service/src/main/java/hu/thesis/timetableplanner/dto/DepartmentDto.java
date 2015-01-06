package hu.thesis.timetableplanner.dto;

import java.util.List;

public class DepartmentDto extends BaseDto{

    private String name;

    private UserDto responsible;

    private List<UserDto> lecturers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDto getResponsible() {
        return responsible;
    }

    public void setResponsible(UserDto responsible) {
        this.responsible = responsible;
    }

    public List<UserDto> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<UserDto> lecturers) {
        this.lecturers = lecturers;
    }

}
