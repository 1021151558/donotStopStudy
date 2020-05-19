package com.zjut.noStopStudy.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "admin")
public class Admin {

    private Integer userId;

    @Id
    private Integer adminId;

    private String name;

    private String sex;

    //精确到班级
    private String institute;

    private String nativePlace;

    private String phoneNumber;

    public Admin(){
        super();
    }
    public Admin(Integer userId, Integer adminId, String name, String sex, String institute, String nativePlace, String phoneNumber) {
        this.userId = userId;
        this.adminId = adminId;
        this.name = name;
        this.sex = sex;
        this.institute = institute;
        this.nativePlace = nativePlace;
        this.phoneNumber = phoneNumber;
    }
}
