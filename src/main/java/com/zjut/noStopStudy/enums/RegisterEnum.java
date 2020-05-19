package com.zjut.noStopStudy.enums;

import lombok.Getter;

@Getter
public enum RegisterEnum {

    SUCCESS(0,"注册成功"),
    FAIL(1,"注册失败"),
    DELETE_FALL(3,"删除失败"),

    ;
    private Integer code;

    private String message;

    RegisterEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
