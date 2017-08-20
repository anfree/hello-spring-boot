package com.company.group.application.module.controller;

import com.company.group.application.module.dao.UserDao;
import com.company.group.application.module.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Restfull 请求调度层
 * Created by 曾祥江 on 2017/6/18 20:55.
 * email: zengxiangjaing@aliyun.com
 */
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有用户
     *
     * @return userList
     */
    @GetMapping(value = "/users")
    public List<User> userList() {
        return userDao.findAll();
    }

    /**
     * 添加一个用户
     *
     * @param user 要添加的对象
     * @return 入库后的对象
     */
    @PostMapping("/user")
    public User userAdd(User user) {
        return userDao.save(user);
    }

    /**
     * 根据主键查找一个对象
     *
     * @param id 主键
     * @return user
     */
    @GetMapping("/user/{id}")
    public User userFindOne(@PathVariable("id") Integer id) {
        User user = userDao.findOne(id);
        logger.info("user={}", user);
        return user;
    }

    /**
     * 根据id更新
     * 注意： Http Put 请求的 Content Type: application/x-www-form-urlencoded
     *
     * @param user 要添加的对象
     * @return 入库后的对象
     */
    @PutMapping("/user/{id}")
    public User userUpdate(User user) {
        return userDao.save(user);
    }

    /**
     * 根据主键删除
     *
     * @param id 主键
     */
    @DeleteMapping("/user/{id}")
    public void userDelete(@PathVariable("id") Integer id) {
        userDao.delete(id);
    }

    /**
     * 通过年龄查询
     *
     * @param age 年龄
     * @return userList
     */
    @GetMapping("/user/age/{age}")
    public List<User> userListByAge(@PathVariable("age") Integer age) {
        return userDao.findByAge(age);
    }

}
