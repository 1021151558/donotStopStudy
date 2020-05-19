package com.zjut.noStopStudy.VO.userManagement;

import lombok.Data;

@Data
public class AdminUserManagementVO {
    private String name;

    private Integer adminId;

    private String phoneNumber;

    public AdminUserManagementVO(String name, Integer adminId, String phoneNumber) {
        this.name = name;
        this.adminId = adminId;
        this.phoneNumber = phoneNumber;
    }
}
