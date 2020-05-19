package com.zjut.noStopStudy.VO.classManagement;

import lombok.Data;

@Data
public class TeachingSituationVO {

    private String courseName;

    private String teacherName;

    private String teachingClass;

    private Integer currentWeek;

    //授课状态
    private String classSituation;

    //持续时间
    private Integer duration;

    public TeachingSituationVO(String courseName, String teachingClass, String teacherName,Integer currentWeek, String classSituation, Integer duration) {
        this.courseName = courseName;
        this.teachingClass = teachingClass;
        this.teacherName = teacherName;
        this.currentWeek = currentWeek;
        this.classSituation = classSituation;
        this.duration = duration;
    }
}
