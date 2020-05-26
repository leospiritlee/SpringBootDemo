package com.leospiritlee.springBootDemo.event;

import com.leospiritlee.springBootDemo.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Project: SpringBootDemo
 * @ClassName MyEventListener
 * @description: 自定义监听组件
 * @author: leospiritlee
 * @create: 2020-05-26 22:14
 **/
@Component
@Slf4j
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        User user = myEvent.getUser();
        log.info("userName: {}", user.getUserName());
        log.info("password: {}", user.getPassword());
    }
}
