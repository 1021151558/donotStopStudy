package com.zjut.noStopStudy.model.modelUtil;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@Data
public class TeachingSituationId implements Serializable {
    @Id
    private Integer courseId;

    @Id
    private String teachingClass;

    public TeachingSituationId(){
        super();
    }

    public TeachingSituationId(Integer courseId, String teachingClass) {
        this.courseId = courseId;
        this.teachingClass = teachingClass;
    }
}
