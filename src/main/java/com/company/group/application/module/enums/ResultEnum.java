package com.company.group.application.module.enums;

/**
 * hello-spring-boot service
 * Created by 曾祥江 on 2017/6/18
 * email: zengxiangjaing@aliyun.com
 */
public enum ResultEnum {
    SUCCESS(1, "成功"),
    FAIL(0, "失败"),
    UNKNOWN_EXCEPTION(-1, "未知异常"),
    PRIMARY_SCHOOL(100, "你还在上小学吧"),
    MIDDLE_SCHOOL(100, "你可能还在上初中")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
