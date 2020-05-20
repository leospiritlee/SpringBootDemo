package com.leospiritlee.springBootDemo.service;

import com.leospiritlee.springBootDemo.entity.User;

import java.util.List;

/**
 * @Project: SpringBootDemo
 * @ClassName UserService
 * @description: userService
 * @author: leospiritlee
 * @create: 2020-05-19 22:36
 **/
public interface UserService {

    User getUser(Long id);

    List<User> getAll();

    User getUserByName(String username);

    User getUser(Long id, String username);
}
