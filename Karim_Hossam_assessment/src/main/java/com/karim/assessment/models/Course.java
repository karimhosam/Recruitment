package com.karim.assessment.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name="Name")
    private String name;
    @Column(name = "description")
    private String description;
    @ElementCollection
    private List<String> steps;
    public Course(){}
    public Course( String name, String description, List<String> steps) {

        this.name = name;
        this.description = description;
        this.steps = steps;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getSteps() {
        return steps;
    }
}
