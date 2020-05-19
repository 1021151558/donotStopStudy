package com.zjut.noStopStudy.VO.classManagement;

//		courseId: 20203999,
////                courseName: "数据库与原理",
////                teacherName: "张一涣",
////                startWeek: 1,
////                endWeek: 8,
////                numberLimit: 60,
////                numberReality: 20,
////                startTerm: "2020上",
////                teachingClass: "A01"
//Integer courseId, Integer teacherId, Integer studentId, String teachingClass
import lombok.Data;

@Data
public class CourseStudentVO {
    private Integer courseId;

    private String courseName;

    private String teacherName;

//    private Integer teacherId;

    private Integer startWeek;

    private Integer endWeek;

    private Integer numberLimit;

    private Integer numberReality;

    private String startTerm;

    private String teachingClass;

    public CourseStudentVO(Integer courseId, String courseName, String teacherName, Integer startWeek, Integer endWeek, Integer numberLimit, Integer numberReality, String startTerm, String teachingClass) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.numberLimit = numberLimit;
        this.numberReality = numberReality;
        this.startTerm = startTerm;
        this.teachingClass = teachingClass;
    }
}
