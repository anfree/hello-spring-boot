package com.company.group.application.module.dao;

import com.company.group.application.module.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户CRUD
 * Created by 曾祥江 on 2017/6/18 21:02.
 * email: zengxiangjaing@aliyun.com
 */
public interface UserDao extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

    List<User> findByAge(Integer age);

}
