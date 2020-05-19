package com.zjut.noStopStudy.service.impl;

import com.zjut.noStopStudy.dao.CourseStudentDao;
import com.zjut.noStopStudy.model.CourseStudent;
import com.zjut.noStopStudy.model.modelUtil.CourseStudentId;
import com.zjut.noStopStudy.service.CourseStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

    @Autowired
    private CourseStudentDao courseStudentDao;

    @Override
    public Page<CourseStudent> findAllByStudentId(Integer studentId, Pageable pageable) {
        return courseStudentDao.findAllByStudentId(studentId,pageable);
    }

    @Override
    public void deleteAllByCourseIdAndTeachingClass(Integer courseId, String teachingClass) {
         courseStudentDao.deleteAllByCourseIdAndTeachingClass(courseId,teachingClass);
    }

    @Override
    public CourseStudent findByCourseStudentId(CourseStudentId courseStudentId) {
        return courseStudentDao.findById(courseStudentId).get();
    }

    @Override
    public CourseStudent findByCourseIdAndTeachingClass(Integer courseId, String teachingClass) {
        return courseStudentDao.findByCourseIdAndTeachingClass(courseId,teachingClass);
    }

    @Override
    public void save(CourseStudent courseStudent) {
        courseStudentDao.save(courseStudent);
    }
}
