package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    @Size(max = 500, message = "Description too long")
    private String description;

    public Skill (String description) {
        this.description = description;
    }


    public Skill () {}


}