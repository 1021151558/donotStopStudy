package com.zjut.noStopStudy.convert;

import com.zjut.noStopStudy.VO.classManagement.TeachingSituationVO;
import com.zjut.noStopStudy.model.TeachingSituation;
import com.zjut.noStopStudy.service.CourseService;
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
public class TeachingClassToTeachingSituationVO {

    @Autowired
    private CourseService cService;

    @Autowired
    private TeacherService tService;

    private static CourseService courseService;

    private static TeacherService teacherService;

    @PostConstruct
    public void init(){
        this.courseService = this.cService;
        this.teacherService = this.tService;
    }

    public static TeachingSituationVO convert(TeachingSituation teachingSituation){
       String courseName = courseService.findByCourseId(teachingSituation.getCourseId()).getCourseName();
       String teacherName = teacherService.findByTeacherId(teachingSituation.getTeacherId()).getName();
       return new TeachingSituationVO(courseName,teachingSituation.getTeachingClass(),teacherName,teachingSituation.getCurrentWeek(),teachingSituation.getClassSituation(),
                                      teachingSituation.getDuration());
    }

    public static Page<TeachingSituationVO> convert(Page<TeachingSituation> teachingSituationPage){
        List<TeachingSituation> teachingSituations = teachingSituationPage.getContent();
        Iterator it  = teachingSituations.iterator();
        List<TeachingSituationVO> teachingSituationVOList = new ArrayList<>();
        while(it.hasNext()){
            teachingSituationVOList.add(convert((TeachingSituation) it.next()));
        }
        return new PageImpl<>(teachingSituationVOList);
    }

}
