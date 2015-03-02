package hu.thesis.timetableplanner.dto;

import java.util.List;

/**
 * Created by Atesz on 2015.02.28..
 */
public class OccupationGroupDto extends BaseDto {

    private String name;

    private List<UserDto> users;

    private List<OccupationDto> occupations;

    public List<OccupationDto> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<OccupationDto> occupations) {
        this.occupations = occupations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
