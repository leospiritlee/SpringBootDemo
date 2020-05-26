package com.leospiritlee.springBootDemo.service;

import com.leospiritlee.springBootDemo.dto.User;
import com.leospiritlee.springBootDemo.event.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Project: SpringBootDemo
 * @ClassName UserEventService
 * @description: 模拟获取user
 * @author: leospiritlee
 * @create: 2020-05-21 21:19
 **/
@Service
public class UserEventService {

    @Resource
    private ApplicationContext applicationContext;

    public User getUser(){
        return new User(1L,"zhangsan", "123456");
    }

    public User getUser2(){
        User user = new User(1L,"zhangsan", "123456");
        MyEvent myEvent = new MyEvent(this, user);
        applicationContext.publishEvent(myEvent);
        return user;
    }

}
