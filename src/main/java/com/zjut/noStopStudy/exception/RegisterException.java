package com.zjut.noStopStudy.exception;

import com.zjut.noStopStudy.enums.RegisterEnum;

public class RegisterException extends RuntimeException {
    private Integer code;

    public RegisterException(RegisterEnum registerEnum){
        super(registerEnum.getMessage());

        this.code = registerEnum.getCode();
    }

    public RegisterException(Integer code ,String message){
        super(message);
        this.code = code;
    }

}
