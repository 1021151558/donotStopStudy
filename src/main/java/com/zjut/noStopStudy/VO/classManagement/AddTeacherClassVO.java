package com.zjut.noStopStudy.VO.classManagement;

import lombok.Data;

@Data
public class AddTeacherClassVO {

    private Integer courseId;

    private String courseName;

    private String description;

    private Integer teacherId;

    private Integer startWeek;

    private Integer endWeek;

    private Integer numberLimit;

    private Integer numberReality;

    private String startTerm;

    private String teachingClass;

    public AddTeacherClassVO(Integer courseId, String courseName, String description, Integer teacherId,Integer startWeek, Integer endWeek, Integer numberLimit, Integer numberReality, String startTerm, String teachingClass) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.teacherId = teacherId;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.numberLimit = numberLimit;
        this.numberReality = numberReality;
        this.startTerm = startTerm;
        this.teachingClass = teachingClass;
    }
}
