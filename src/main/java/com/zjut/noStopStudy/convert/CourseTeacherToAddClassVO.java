package com.zjut.noStopStudy.convert;

import com.zjut.noStopStudy.VO.classManagement.AddTeacherClassVO;
import com.zjut.noStopStudy.model.Course;
import com.zjut.noStopStudy.model.CourseTeacher;
import com.zjut.noStopStudy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CourseTeacherToAddClassVO {

    @Autowired
    private CourseService courseService;

    private static CourseService courseS;

    @PostConstruct
    public void init(){
        this.courseS = this.courseService;
    }

    public static AddTeacherClassVO convert(CourseTeacher courseTeacher){

        Course course = courseS.findByCourseId(courseTeacher.getCourseId());
        return new AddTeacherClassVO(courseTeacher.getCourseId(),course.getCourseName(),course.getDescription(),
                    courseTeacher.getTeacherId(),courseTeacher.getStartWeek(),courseTeacher.getEndWeek(),
                    courseTeacher.getNumberLimit(),courseTeacher.getNumberReality(),courseTeacher.getStartTerm(),
                    courseTeacher.getTeachingClass());
    }

    public static Page<AddTeacherClassVO> convert(Page<CourseTeacher> courseTeacherPage){
        List<CourseTeacher> courseTeacherList = courseTeacherPage.getContent();
        Iterator it = courseTeacherList.iterator();
        List<AddTeacherClassVO> addTeacherClassVOList = new ArrayList<>();
        while (it.hasNext()){
            addTeacherClassVOList.add(convert((CourseTeacher) it.next()));
        }

        return new PageImpl<>(addTeacherClassVOList);
    }

}
