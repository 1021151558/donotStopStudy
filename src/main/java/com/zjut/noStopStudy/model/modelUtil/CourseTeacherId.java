package com.zjut.noStopStudy.model.modelUtil;

import lombok.Data;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public class CourseTeacherId implements Serializable {
    @Id
    private Integer courseId;

    @Id
    private String teachingClass;

    public CourseTeacherId(){
        super();
    }
    public CourseTeacherId(Integer courseId, String teachingClass) {
        this.courseId = courseId;
        this.teachingClass = teachingClass;
    }
}
