package hu.thesis.timetableplanner.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "group")
public class Group extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @JoinTable(name = "inGroup", joinColumns = {
            @JoinColumn(name = "group", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users;

    @JoinTable(name = "groupOccupied", joinColumns = {
            @JoinColumn(name = "group", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "occupation", referencedColumnName = "id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Occupation> occupations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Occupation> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<Occupation> occupations) {
        this.occupations = occupations;
    }
}
