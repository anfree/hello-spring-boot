package com.company.group.application.module.service;

import com.company.group.application.module.dao.UserDao;
import com.company.group.application.module.entity.User;
import com.company.group.application.module.enums.ResultEnum;
import com.company.group.application.module.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * hello-spring-boot service
 * Created by 曾祥江 on 2017/6/18
 * Email: zengxiangjaing@aliyun.com
 */
@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public User getAge(Integer id) throws UserException {
        User user = userDao.findOne(id);
        logger.info("user={}", user);
        Integer age = user.getAge();
        if (10> age){
            throw new UserException(ResultEnum.PRIMARY_SCHOOL);
        }else if (10 < age && 18> age){
            throw new UserException(ResultEnum.MIDDLE_SCHOOL);
        }else {
            logger.info("正常");
        }
        return user;
    }
}
