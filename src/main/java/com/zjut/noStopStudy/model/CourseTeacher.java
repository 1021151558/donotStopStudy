package com.zjut.noStopStudy.model;

import com.zjut.noStopStudy.model.modelUtil.CourseTeacherId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity(name = "course_teacher")
@IdClass(CourseTeacherId.class)
public class CourseTeacher extends CourseTeacherId {


    private Integer teacherId;

    private int startWeek;

    private int endWeek;

    private int numberLimit;

    private int numberReality;

    private String startTerm;



    public CourseTeacher(){
        super();
    }
    public CourseTeacher(Integer courseId, Integer teacherId, int startWeek, int endWeek, int numberLimit, int numberReality, String startTerm, String teachingClass) {
        super(courseId,teachingClass);
        this.teacherId = teacherId;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.numberLimit = numberLimit;
        this.numberReality = numberReality;
        this.startTerm = startTerm;

    }
}
