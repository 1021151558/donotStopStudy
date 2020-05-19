package com.zjut.noStopStudy.VO.userManagement;

import lombok.Data;

@Data
public class StudentUserManagementVO {
    private String name;

    private Integer studentId;

    private String phoneNumber;

    public StudentUserManagementVO(String name, Integer studentId, String phoneNumber) {
        this.name = name;
        this.studentId = studentId;
        this.phoneNumber = phoneNumber;
    }
}
