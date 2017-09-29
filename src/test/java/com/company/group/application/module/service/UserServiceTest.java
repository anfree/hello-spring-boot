package com.company.group.application.module.service;

import com.company.group.application.module.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试 service
 * Created by 曾祥江 on 2017/6/18
 * email: zengxiangjaing@aliyun.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void getAge() throws Exception {
        User user = userService.getAge(2);
        logger.info("user={}", user);
        Assert.assertEquals(new Integer("16"), user.getAge());
    }

}