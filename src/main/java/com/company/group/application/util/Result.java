package com.company.group.application.util;

/**
 * http请求返回的最外层对象
 * Created by 曾祥江 on 2017/6/18
 * email: zengxiangjaing@aliyun.com
 */
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
