package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

    @NotBlank(message = "This field should not be left blank")
    @Size(max = 100)
    private String location;

    @OneToMany (mappedBy = "employer")
    @JoinColumn
    private final List<Job> events = new ArrayList<>();

    public Employer (@Size(max=100, message = "This field should not be left blank") String location) {
        this.location = location;
    }

    public Employer () {}

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
