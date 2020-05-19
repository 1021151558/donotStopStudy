package com.zjut.noStopStudy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "student")
public class Student {

    private Integer userId;

    @Id
    private Integer studentId;

    private String name;

    private String sex;

    //精确到班级
    private String institute;

    private String nativePlace;

    private String phoneNumber;

    public Student(){
        super();
    }

    public Student(Integer userId, Integer studentId, String name, String sex, String institute, String nativePlace, String phoneNumber) {
        this.userId = userId;
        this.studentId = studentId;
        this.name = name;
        this.sex = sex;
        this.institute = institute;
        this.nativePlace = nativePlace;
        this.phoneNumber = phoneNumber;
    }
}
