package com.company.group.application.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 曾祥江 on 2017/6/18 18:45.
 * email: zengxiangjaing@aliyun.com
 */
@RestController
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String say(){
//        String message = "Hello Spring Boot";
//        String message = name + age;
        String message = content;
        System.out.println(message);
        return message;
    }

}
