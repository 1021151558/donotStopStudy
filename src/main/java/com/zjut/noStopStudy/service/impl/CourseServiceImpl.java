package com.zjut.noStopStudy.service.impl;

import com.zjut.noStopStudy.dao.CourseDao;
import com.zjut.noStopStudy.model.Course;
import com.zjut.noStopStudy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public Course save(Course course) {
        return courseDao.save(course);
    }

    @Override
    public Course findByCourseId(Integer id) {
//        System.out.println("courseServiceImpl id"+id);
        return courseDao.findById(id).get();
    }
}
