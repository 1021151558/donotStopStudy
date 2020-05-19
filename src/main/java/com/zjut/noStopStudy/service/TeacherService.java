package com.zjut.noStopStudy.service;

import com.zjut.noStopStudy.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    Teacher findByUserId(Integer userId);

    Teacher save(Teacher teacher);

    Page<Teacher> findAll(Pageable pageable);

    Teacher findByTeacherId(Integer id);

    void deleteByTeacherId(Integer id);
}
