package com.zjut.noStopStudy.dao;

import com.zjut.noStopStudy.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends JpaRepository<Teacher,Integer> {
    Teacher findByUserId(Integer userId);

//    Teacher findByTeacherId(Integer teacherId);

}
