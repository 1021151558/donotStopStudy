package com.zjut.noStopStudy.service;

import com.zjut.noStopStudy.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Student findByUserId(Integer userId);

    Student save(Student student);

    Page<Student> findAll(Pageable pageable);

    Student findByStudentId(Integer studentId);

    void deleteByStudentId(Integer studentId);
}
