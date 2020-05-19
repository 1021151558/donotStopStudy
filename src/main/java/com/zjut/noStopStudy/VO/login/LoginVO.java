package com.zjut.noStopStudy.VO.login;

import lombok.Data;

@Data
public class LoginVO {
    private String userName;

    private String password;

    public LoginVO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
