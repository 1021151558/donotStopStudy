package com.zjut.noStopStudy.service.impl;

import com.zjut.noStopStudy.dao.CourseTeacherDao;
import com.zjut.noStopStudy.model.CourseTeacher;
import com.zjut.noStopStudy.model.modelUtil.CourseTeacherId;
import com.zjut.noStopStudy.service.CourseTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;




@Service
public class CourseTeacherServiceImpl implements CourseTeacherService {

    @Autowired
    private CourseTeacherDao courseTeacherDao;

    @Override
    public CourseTeacher save(CourseTeacher courseTeacher) {
        return courseTeacherDao.save(courseTeacher);
    }

    @Override
    public Page<CourseTeacher> findAll(Pageable pageable) {
        return courseTeacherDao.findAll(pageable);
    }

    @Override
    public CourseTeacher findByCourseTeacherId(CourseTeacherId courseTeacherId) {
        return courseTeacherDao.findById(courseTeacherId).get();
    }

    @Override
    public Page<CourseTeacher> findAllByTeacherId(Integer teacherId, Pageable pageable) {
        return courseTeacherDao.findAllByTeacherId(teacherId,pageable);
    }

    @Override
    public void deleteByCourseTeacherId(CourseTeacherId courseTeacherId) {
        courseTeacherDao.deleteById(courseTeacherId);
    }

    @Override
    public Page<CourseTeacher> findAllByCourseId(Integer courseId, Pageable pageable) {
        return courseTeacherDao.findAllByCourseId(courseId,pageable);
    }
}
