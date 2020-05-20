package com.leospiritlee.springBootDemo.service.impl;

import com.leospiritlee.springBootDemo.dao.UserMapper;
import com.leospiritlee.springBootDemo.entity.User;
import com.leospiritlee.springBootDemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Project: SpringBootDemo
 * @ClassName UserServiceImpl
 * @description: user service 实现
 * @author: leospiritlee
 * @create: 2020-05-19 22:39
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public User getUser(Long id, String username) {
        return userMapper.getUserByIdAndName(id, username);
    }
}
