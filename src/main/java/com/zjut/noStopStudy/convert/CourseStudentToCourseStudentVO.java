package com.zjut.noStopStudy.convert;


import com.zjut.noStopStudy.VO.classManagement.AddTeacherClassVO;
import com.zjut.noStopStudy.VO.classManagement.CourseStudentVO;
import com.zjut.noStopStudy.model.CourseStudent;
import com.zjut.noStopStudy.service.CourseStudentService;
import com.zjut.noStopStudy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseStudentToCourseStudentVO {

    @Autowired
    private CourseStudentService cStudentService;

    @Autowired
    private TeacherService tService;

    private static CourseStudentService courseStudentService;

    private static TeacherService teacherService;

    @PostConstruct
    public void init(){
        courseStudentService = this.cStudentService;
        teacherService = this.tService;
    }
//    Integer courseId, Integer teacherId, Integer studentId, String teachingClass
    public static CourseStudentVO convert(CourseStudent courseStudent){

       AddTeacherClassVO addTeacherClassVO =CourseStudentToAddTeacherClassVO.convert(courseStudent);
       return new CourseStudentVO(addTeacherClassVO.getCourseId(),addTeacherClassVO.getCourseName(),teacherService.findByTeacherId(addTeacherClassVO.getTeacherId()).getName(),
               addTeacherClassVO.getStartWeek(),addTeacherClassVO.getEndWeek(),addTeacherClassVO.getNumberLimit(),addTeacherClassVO.getNumberReality(),addTeacherClassVO.getStartTerm(),
               addTeacherClassVO.getTeachingClass());
    }

    public static Page<CourseStudentVO> convert(Page<CourseStudent> courseStudentPage){
        List<CourseStudent> courseStudentList = courseStudentPage.getContent();
        Iterator it = courseStudentList.iterator();
        List<CourseStudentVO> courseStudentVOList = new ArrayList<>();
        while (it.hasNext()){
            courseStudentVOList.add(convert((CourseStudent) it.next()));
        }
        return new PageImpl<>(courseStudentVOList);
    }
}
