package com.zjut.noStopStudy.model.modelUtil;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public class CourseStudentId implements Serializable {

    @Id
    private Integer courseId;

    @Id
    private Integer studentId;

    public CourseStudentId(){
        super();
    }

    public CourseStudentId(Integer courseId, Integer studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }
}
