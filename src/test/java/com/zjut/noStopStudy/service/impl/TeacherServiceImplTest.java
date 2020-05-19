package com.zjut.noStopStudy.service.impl;

import com.zjut.noStopStudy.NoStopStudyApplicationTests;
import com.zjut.noStopStudy.model.Teacher;
import com.zjut.noStopStudy.service.TeacherService;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class TeacherServiceImplTest extends NoStopStudyApplicationTests {

    @Autowired
    private TeacherService teacherService;

    @Test
    public void findByTeacherId() {
        Assert.assertNotNull(teacherService.findByTeacherId(new Integer(2111900101)));
        Assert.assertNotNull("123",teacherService.findByTeacherId(new Integer(2111900101)));
    }

    @Test
    public void save(){
        Teacher teacher = teacherService.findByTeacherId(2111900101);
        System.out.println(teacher);
        Assert.assertNotNull(teacherService.save(teacher));
    }
}