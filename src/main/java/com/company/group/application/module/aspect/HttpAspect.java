package com.company.group.application.module.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试aspect
 * Created by 曾祥江 on 2017/6/18
 * Email: zengxiangjaing@aliyun.com
 */
@Aspect
@Component
public class HttpAspect {
    private Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.company.group.application.module.controller.UserController.*(..))")
    public void log() {}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("doBefore start 11111111111111111111");
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest hsr = sra.getRequest();
        //url
        StringBuffer url = hsr.getRequestURL();
        logger.info("url={}", url);
        //method
        String method = hsr.getMethod();
        logger.info("method={}", method);
        //ip
        String ip = hsr.getRemoteAddr();
        logger.info("ip={}", ip);
        //类方法
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        logger.info("class_method={}", classMethod);
        //参数
        Object[] args = joinPoint.getArgs();
        logger.info("args={}", args);
    }

    @After("log()")
    public void doAfter() {
        logger.info("doAfter end 22222222222222222222");
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturing(Object object){
        logger.info("response={}", object.toString());
    }
}
