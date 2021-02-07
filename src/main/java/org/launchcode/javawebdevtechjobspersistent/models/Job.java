package org.launchcode.javawebdevtechjobspersistent.models;

import javax.persistence.*;

@Entity
public class Job extends AbstractEntity{
// To be remover per instructions
//    @Id
//    @GeneratedValue
//    private int id;

//    private String name;

    // Replace the type of the field employer to be of type Employer.
    // You will also need to refactor the affected constructor and getter and setter that use this field.
    // Add the @ManyToOne annotation on the field employer
    @ManyToOne
    private Employer employer;
    private String skills;

    public Job() {
    }

    public Job(Employer employer, String someSkills) {
        super();
        this.employer = employer;
        this.skills = someSkills;
    }

    // Getters and setters.

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
