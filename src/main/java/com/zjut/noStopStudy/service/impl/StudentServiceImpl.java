package com.zjut.noStopStudy.service.impl;

import com.zjut.noStopStudy.dao.StudentDao;
import com.zjut.noStopStudy.model.Student;
import com.zjut.noStopStudy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findByUserId(Integer userId) {
        return studentDao.findByUserId(userId);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentDao.findAll(pageable);
    }

    @Override
    public Student findByStudentId(Integer studentId) {
        System.out.println(studentId);
        return studentDao.findById(studentId).get();
    }

    @Override
    public void deleteByStudentId(Integer studentId) {
        studentDao.deleteById(studentId);
    }
}
