package com.company.group.application.util;

import com.company.group.application.module.enums.ResultEnum;

/**
 * http请求返回的最外层对象工具
 * Created by 曾祥江 on 2017/6/18
 * Email: zengxiangjaing@aliyun.com
 */
public class ResultUtil {

    /**
     * 返回成功数据
     * @param data 要返回的数据
     * @return 统一格式的结果
     */
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    /**
     * 返回失败数据
     * @return 统一格式的结果
     */
    public static <T> Result<T> fail(Integer code, String message){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

}
