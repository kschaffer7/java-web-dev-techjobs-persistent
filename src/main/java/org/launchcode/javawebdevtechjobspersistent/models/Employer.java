package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

// Employer is a class that will be mapped to one of our tables.
    // Make sure the class has the @Entity annotation,
    // as well as the no-arg constructor required for Hibernate to create an object.
@Entity
public class Employer extends AbstractEntity {

    // In addition to the fields inherited from AbstractEntity,
    // Employer should have a string field for location.
    // Add the field for location with validation.

    @NotBlank(message = "Location is required")
    @Size(min = 1, max = 200, message = "Location must be between 1 and 200 characters")
    private String location;

    //Within Employer, add a private property jobs of type List<Job> and initialize it to an empty ArrayList.
    // After we set up the Job class to work with Employer objects, this list will represent the list of all items in a given job.
    // Use the @OneToMany and @JoinColumn annotations on the jobs list in Employer to declare the relationship between data tables.
    @OneToMany
    @JoinColumn
    private List<Job> jobs = new ArrayList<>();

    // In addition, add getters and setters to Employer.
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // the no-arg constructor required for Hibernate to create an object.
    public Employer () {}
}
