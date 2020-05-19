package com.zjut.noStopStudy.dao;

import com.zjut.noStopStudy.NoStopStudyApplicationTests;

import com.zjut.noStopStudy.model.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;




public class TeacherDaoTest extends NoStopStudyApplicationTests {
    @Autowired
    private TeacherDao teacherDao;

    @Test
    public void findByUserId() {
    }

    @Test
    public void findAll(){
        PageRequest pageRequest = PageRequest.of(0,6);
        Page<Teacher> result = teacherDao.findAll(pageRequest);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByTeacherId(){
      //  Assert.assertNotNull(teacherDao.findByTeacherId(new Integer(2111900101)));
    }

    @Test
    public void findById(){
        Assert.assertNotNull("123",teacherDao.findById(new Integer(2111900101)));
    }
}