package com.zjut.noStopStudy.service;

import com.zjut.noStopStudy.model.Course;

public interface CourseService {

    Course save(Course course);

    Course findByCourseId(Integer id);
}
