package hu.thesis.timetableplanner.dto;

import java.util.List;

public class DepartmentDto extends BaseDto{

    private String name;

    private LecturerDto responsible;

    private List<LecturerDto> lecturers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LecturerDto getResponsible() {
        return responsible;
    }

    public void setResponsible(LecturerDto responsible) {
        this.responsible = responsible;
    }

    public List<LecturerDto> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<LecturerDto> lecturers) {
        this.lecturers = lecturers;
    }

}
