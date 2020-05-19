package com.zjut.noStopStudy.dao;

import com.zjut.noStopStudy.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {
    Student findByUserId(Integer userId);
}
