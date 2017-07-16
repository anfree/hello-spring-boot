package com.company.group.application.module.controller;

import com.company.group.application.module.dao.UserDao;
import com.company.group.application.module.entity.User;
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

    @Autowired
    private UserDao userDao;

    /**
     * 查询所有用户
     * @return userList
     */
    @GetMapping(value = "/users")
    public List<User> userList(){
        return userDao.findAll();
    }

    /**
     * 添加一个用户
     * @param name 姓名
     * @param age 年龄
     * @return user
     */
    @PostMapping("/user")
    public User userAdd(User user){
        return userDao.save(user);
    }

    /**
     * 根据主键查找一个对象
     * @param id 主键
     * @return user
     */
    @GetMapping("/user/{id}")
    public User userFindOne(@PathVariable("id") Integer id){
        User user = userDao.findOne(id);
        return user;
    }

    /**
     * 根据id更新
     * 注意： Http Put 请求的 Content Type: application/x-www-form-urlencoded
     * @param id 主键
     * @param name 姓名
     * @param age 年龄
     * @return user
     */
    @PutMapping("/user/{id}")
    public User userUpdate(@PathVariable("id") Integer id, @RequestParam("name") String name, @RequestParam("age") Integer age){
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return userDao.save(user);
    }

    /**
     * 根据主键删除
     * @param id 主键
     */
    @DeleteMapping("/user/{id}")
    public void userDelete(@PathVariable("id") Integer id){
        userDao.delete(id);
    }

    /**
     * 通过年龄查询
     * @param age 年龄
     * @return userList
     */
    @GetMapping("/user/age/{age}")
    public List<User> userListByAge(@PathVariable("age") Integer age){
        return userDao.findByAge(age);
    }

}
