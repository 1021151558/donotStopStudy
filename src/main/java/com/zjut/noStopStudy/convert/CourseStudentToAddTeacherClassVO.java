package com.zjut.noStopStudy.convert;

import com.zjut.noStopStudy.VO.classManagement.AddTeacherClassVO;
import com.zjut.noStopStudy.model.CourseStudent;
import com.zjut.noStopStudy.model.CourseTeacher;
import com.zjut.noStopStudy.model.modelUtil.CourseTeacherId;
import com.zjut.noStopStudy.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseStudentToAddTeacherClassVO {

    @Autowired
    private CourseTeacherService cTeacherService;

    private static CourseTeacherService courseTeacherService;

    @PostConstruct
    public void init(){
        courseTeacherService = this.cTeacherService;
    }

    public static AddTeacherClassVO convert(CourseStudent courseStudent){
       CourseTeacher courseTeacher = courseTeacherService.findByCourseTeacherId(new CourseTeacherId(courseStudent.getCourseId(),courseStudent.getTeachingClass()));
       return CourseTeacherToAddClassVO.convert(courseTeacher);
    }

    public static Page<AddTeacherClassVO> convert(Page<CourseStudent> courseStudentPage){
        List<CourseStudent> courseStudentList = courseStudentPage.getContent();
        Iterator it = courseStudentList.iterator();
        List<AddTeacherClassVO> addTeacherClassVOList = new ArrayList<>();
        while(it.hasNext()){
            addTeacherClassVOList.add(convert((CourseStudent) it.next()));
        }
        return new PageImpl<>(addTeacherClassVOList);
    }
}
