package com.zjut.noStopStudy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "teacher")
public class Teacher {

    private Integer userId;

    @Id
    private Integer teacherId;

    private String name;

    private String sex;

    private String institute;

    //户籍
    private String nativePlace;

    private String phoneNumber;

    public Teacher(){
        super();
    }
    public Teacher(Integer userId, Integer teacherId, String name, String sex, String institute, String nativePlace, String phoneNumber) {
        this.userId = userId;
        this.teacherId = teacherId;
        this.name = name;
        this.sex = sex;
        this.institute = institute;
        this.nativePlace = nativePlace;
        this.phoneNumber = phoneNumber;
    }
}
