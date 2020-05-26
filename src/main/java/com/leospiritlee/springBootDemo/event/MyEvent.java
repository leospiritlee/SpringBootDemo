package com.leospiritlee.springBootDemo.event;

import com.leospiritlee.springBootDemo.dto.User;
import org.springframework.context.ApplicationEvent;

/**
 * @Project: SpringBootDemo
 * @ClassName MyEvent
 * @description: 自定义监听事件
 * @author: leospiritlee
 * @create: 2020-05-26 22:13
 **/
public class MyEvent extends ApplicationEvent {

    private User user;

    public MyEvent(Object source) {
        super(source);
    }

    public MyEvent(Object source, User user) {
        super(source);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
