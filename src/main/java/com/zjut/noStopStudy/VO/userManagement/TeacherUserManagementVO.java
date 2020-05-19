package com.zjut.noStopStudy.VO.userManagement;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeacherUserManagementVO{

    private String name;

    private Integer teacherId;

    private String phoneNumber;

    public TeacherUserManagementVO(String name, Integer teacherId, String phoneNumber) {
        this.name = name;
        this.teacherId = teacherId;
        this.phoneNumber = phoneNumber;
    }
}
