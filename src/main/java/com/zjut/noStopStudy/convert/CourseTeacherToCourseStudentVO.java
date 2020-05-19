package com.zjut.noStopStudy.convert;

import com.zjut.noStopStudy.VO.classManagement.AddTeacherClassVO;
import com.zjut.noStopStudy.VO.classManagement.CourseStudentVO;
import com.zjut.noStopStudy.model.CourseTeacher;
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
public class CourseTeacherToCourseStudentVO {

    @Autowired
    private TeacherService tService;

    private static TeacherService teacherService;

    @PostConstruct
    public void init(){
        teacherService = this.tService;
    }

    public static CourseStudentVO convert(CourseTeacher courseTeacher){
        AddTeacherClassVO addTeacherClassVO =CourseTeacherToAddClassVO.convert(courseTeacher);
        return new CourseStudentVO(addTeacherClassVO.getCourseId(),addTeacherClassVO.getCourseName(),teacherService.findByTeacherId(addTeacherClassVO.getTeacherId()).getName(),
                addTeacherClassVO.getStartWeek(),addTeacherClassVO.getEndWeek(),addTeacherClassVO.getNumberLimit(),addTeacherClassVO.getNumberReality(),addTeacherClassVO.getStartTerm(),
                addTeacherClassVO.getTeachingClass());
    }

    public static Page<CourseStudentVO> convert(Page<CourseTeacher> courseTeacherPage){
        List<CourseTeacher> courseTeacherList = courseTeacherPage.getContent();
        Iterator it = courseTeacherList.iterator();
        List<CourseStudentVO> courseStudentVOList = new ArrayList<>();
        while (it.hasNext()){
            courseStudentVOList.add(convert((CourseTeacher) it.next()));
        }
        return new PageImpl<>(courseStudentVOList);
    }
}
