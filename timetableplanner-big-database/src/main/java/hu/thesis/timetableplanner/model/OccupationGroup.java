package hu.thesis.timetableplanner.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "occupationGroup")
public class OccupationGroup extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @JoinTable(name = "inOccupationGroup", joinColumns = {
            @JoinColumn(name = "occupationGroup", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user", referencedColumnName = "id")})
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> users;

    @JoinTable(name = "groupOccupied", joinColumns = {
            @JoinColumn(name = "occupationGroup", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "occupation", referencedColumnName = "id")})
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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
