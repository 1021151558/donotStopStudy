package com.zjut.noStopStudy.model;

import com.zjut.noStopStudy.model.modelUtil.CourseStudentId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity(name = "course_student")
@IdClass(CourseStudentId.class)
public class CourseStudent extends CourseStudentId {

    private Integer teacherId;

    private String teachingClass;

    public CourseStudent(){
        super();
    }
    public CourseStudent(Integer courseId, Integer teacherId, Integer studentId, String teachingClass) {
        super(courseId,studentId);
        this.teacherId = teacherId;
        this.teachingClass = teachingClass;
    }
}
