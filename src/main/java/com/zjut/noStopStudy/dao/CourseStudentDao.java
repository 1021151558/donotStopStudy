package com.zjut.noStopStudy.dao;

import com.zjut.noStopStudy.model.CourseStudent;
import com.zjut.noStopStudy.model.modelUtil.CourseStudentId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseStudentDao extends JpaRepository<CourseStudent, CourseStudentId> {

    Page<CourseStudent> findAllByStudentId(Integer studentId, Pageable pageable);

    CourseStudent findByCourseIdAndTeachingClass(Integer courseId,String teachingClass);
//    CourseStudent findByCourseIdAndTeachingClass(Integer courseId,String teachingClass);

    void deleteAllByCourseIdAndTeachingClass(Integer courseId,String teachingClass);
}
