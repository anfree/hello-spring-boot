package com.company.group.application.module.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 测试aspect
 * Auther： anfree
 * Email： zengxiangjiang@aliyun.com
 */
@Aspect
@Component
public class HttpAspect {
    private Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.company.group.application.module.controller.UserController.*(..))")
    public void log() {}

    @Before("log()")
    public void doBefore() {
        logger.info("doBefore start 11111111111111111111");
    }

    @After("log()")
    public void doAfter() {
        logger.info("doAfter end 22222222222222222222");
    }
}
