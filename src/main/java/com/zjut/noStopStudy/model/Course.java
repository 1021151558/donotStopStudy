package com.zjut.noStopStudy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@Entity
@Table(name = "course",uniqueConstraints={@UniqueConstraint(columnNames = "courseName")})
public class Course {
    @Id
    private Integer id;

    private String courseName;

    private String description;

    public Course() {
        super();
    }

    public Course(Integer id, String courseName, String description) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
    }
}
