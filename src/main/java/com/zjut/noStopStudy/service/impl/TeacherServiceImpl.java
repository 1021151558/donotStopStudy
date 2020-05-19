package com.zjut.noStopStudy.service.impl;

import com.zjut.noStopStudy.dao.TeacherDao;
import com.zjut.noStopStudy.model.Teacher;
import com.zjut.noStopStudy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Teacher findByUserId(Integer userId) {
        return teacherDao.findByUserId(userId);
    }

    @Override
    public Teacher save(Teacher teacher) {
//        System.out.println("teacherSave");
        return teacherDao.save(teacher);
    }

    @Override
    public Page<Teacher> findAll(Pageable pageable) {
        return teacherDao.findAll(pageable);
    }

    @Override
    public Teacher findByTeacherId(Integer id) {
        return teacherDao.findById(id).get();
    }

    @Override
    public void deleteByTeacherId(Integer id) {
        teacherDao.deleteById(id);
    }
}
