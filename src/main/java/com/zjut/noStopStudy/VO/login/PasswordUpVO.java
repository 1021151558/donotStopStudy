package com.zjut.noStopStudy.VO.login;

import lombok.Data;

@Data
public class PasswordUpVO {

    private String userName;
    private String password;
    private String newPassword;
    private String checkNewPassword;

    public PasswordUpVO(String userName, String password, String newPassword, String checkNewPassword) {
        this.userName = userName;
        this.password = password;
        this.newPassword = newPassword;
        this.checkNewPassword = checkNewPassword;
    }
}
