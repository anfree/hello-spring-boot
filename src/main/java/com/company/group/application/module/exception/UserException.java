package com.company.group.application.module.exception;

import com.company.group.application.module.enums.ResultEnum;

/**
 * 统一异常封装
 * Created by 曾祥江 on 2017/6/18
 * email: zengxiangjaing@aliyun.com
 */
public class UserException extends RuntimeException {
    private Integer code;

    public UserException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

}
