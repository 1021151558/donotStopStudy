package com.zjut.noStopStudy.service;

import com.zjut.noStopStudy.model.CourseTeacher;
import com.zjut.noStopStudy.model.modelUtil.CourseTeacherId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CourseTeacherService {
    CourseTeacher save(CourseTeacher courseTeacher);
    Page<CourseTeacher> findAll(Pageable pageable);
    CourseTeacher findByCourseTeacherId(CourseTeacherId courseTeacherId);
    Page<CourseTeacher> findAllByTeacherId(Integer teacherId,Pageable pageable);
    void deleteByCourseTeacherId(CourseTeacherId courseTeacherId);
    Page<CourseTeacher> findAllByCourseId(Integer courseId,Pageable pageable);
}
