package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job extends AbstractEntity {


    @ManyToOne
    @NotNull(message = "Employer is required")
    private Employer employer;

    private final List<Skill> skills = new ArrayList<>();

    public Job() {
    }

    public Job(Employer employer) {
        super();
        this.employer = employer;
    }

    // Getters and setters.

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Skill skills) {
        this.skills.add(skills);
    }
}
