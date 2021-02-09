package org.launchcode.javawebdevtechjobspersistent.models;

// In the model class Skill, add a field for a longer description of the skill.
// Some hiring managers like to have more information available about the nature of a given programming language or framework.

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

// As with Employer, give this class the @Entity annotation and be sure it contains a no-arg constructor.
@Entity
public class Skill extends AbstractEntity {

    @Size(min = 10, max = 1000, message = "Long Description must be between 10 and 1000 characters")
    private String description;


    // Add a jobs field and determine the type of field it should be.
    // This field has a many-to-many type relationship with skills.
    // You’ll need to add the @ManyToMany annotation with an argument mappedBy="skills" to ensure this mapping
    @ManyToMany(mappedBy="skills")
    private List<Job> jobs = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // the no-arg constructor required for Hibernate to create an object.
    public Skill () {}

    public List<Job> getJobs() {
        return jobs;
    }


}