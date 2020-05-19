package com.zjut.noStopStudy.enums;

import lombok.Getter;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 20:11 2019/3/3/003
 */
@Getter
public enum ShuoShuoSaveEnum {
    SUCCESS(0,"保存成功"),
    FAIL(1,"保存失败")
    ;
    private Integer code;

    private String message;

    ShuoShuoSaveEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}