package org.launchcode.javawebdevtechjobspersistent.models;

// In the model class Skill, add a field for a longer description of the skill.
// Some hiring managers like to have more information available about the nature of a given programming language or framework.

import javax.persistence.Entity;
import javax.validation.constraints.Size;

// As with Employer, give this class the @Entity annotation and be sure it contains a no-arg constructor.
@Entity
public class Skill extends AbstractEntity {

    @Size(min = 10, max = 1000, message = "Long Description must be between 10 and 1000 characters")
    private String longDescription;

    // the no-arg constructor required for Hibernate to create an object.
    public Skill () {}

}