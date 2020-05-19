package com.zjut.noStopStudy.dao;

import com.zjut.noStopStudy.model.CourseTeacher;
import com.zjut.noStopStudy.model.modelUtil.CourseTeacherId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTeacherDao extends JpaRepository<CourseTeacher, CourseTeacherId> {
    Page<CourseTeacher> findAllByTeacherId(Integer teacherId , Pageable pageable);

    Page<CourseTeacher> findAllByCourseId(Integer courseId,Pageable pageable);
}
