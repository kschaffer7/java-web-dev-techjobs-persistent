package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
