package com.zjut.noStopStudy.model;

import com.zjut.noStopStudy.model.modelUtil.TeachingSituationId;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

//	teacherName: "梨花",
//            teachingClass: "A03",
//            courseName: "数据仓库",
//            currentClass: 5,
//            classSituation: "暂未开始",
//            duration: 0
@Data
@Entity(name = "teaching_situation")
@IdClass(TeachingSituationId.class)
public class TeachingSituation extends TeachingSituationId {

    private Integer teacherId;

    private int currentWeek;

    private String classSituation;

    //上课时长
    private int duration;

    public TeachingSituation(){
        super();
    }
    public TeachingSituation(Integer courseId, Integer teacherId, int currentWeek, String classSituation, int duration, String teachingClass) {
        super(courseId,teachingClass);
        this.teacherId = teacherId;
        this.currentWeek = currentWeek;
        this.classSituation = classSituation;
        this.duration = duration;
    }
}
