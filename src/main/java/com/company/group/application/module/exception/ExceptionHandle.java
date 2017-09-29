package com.company.group.application.module.exception;

import com.company.group.application.module.enums.ResultEnum;
import com.company.group.application.util.Result;
import com.company.group.application.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 * Created by 曾祥江 on 2017/6/18
 * Email: zengxiangjaing@aliyun.com
 */
@ControllerAdvice
public class ExceptionHandle {
    private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        logger.info("enter unite exception handle...");
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return ResultUtil.fail(userException.getCode(), userException.getMessage());
        } else {
            logger.info("系统异常: {}", e);
            return ResultUtil.fail(ResultEnum.UNKNOWN_EXCEPTION.getCode(), ResultEnum.UNKNOWN_EXCEPTION.getMessage());
        }
    }

}
