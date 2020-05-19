package com.zjut.noStopStudy.dao;

import com.zjut.noStopStudy.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course,Integer> {
}
