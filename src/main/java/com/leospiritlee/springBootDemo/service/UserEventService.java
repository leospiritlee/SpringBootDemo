package com.leospiritlee.springBootDemo.service;

import com.leospiritlee.springBootDemo.dto.User;
import org.springframework.stereotype.Service;

/**
 * @Project: SpringBootDemo
 * @ClassName UserEventService
 * @description: 模拟获取user
 * @author: leospiritlee
 * @create: 2020-05-21 21:19
 **/
@Service
public class UserEventService {


    public User getUser(){
        return new User(1L,"zhangsan", "123456");
    }
}
