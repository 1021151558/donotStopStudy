package com.zjut.noStopStudy.service;

import com.zjut.noStopStudy.model.CourseStudent;
import com.zjut.noStopStudy.model.modelUtil.CourseStudentId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseStudentService {

    Page<CourseStudent> findAllByStudentId(Integer studentId, Pageable pageable);
    void deleteAllByCourseIdAndTeachingClass(Integer courseId,String teachingClass);
    CourseStudent findByCourseStudentId(CourseStudentId courseStudentId);
    CourseStudent findByCourseIdAndTeachingClass(Integer courseId,String teachingClass);
    void save(CourseStudent courseStudent);
}
