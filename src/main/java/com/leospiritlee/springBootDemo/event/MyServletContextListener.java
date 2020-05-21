package com.leospiritlee.springBootDemo.event;

import com.leospiritlee.springBootDemo.dto.User;
import com.leospiritlee.springBootDemo.service.UserEventService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

/**
 * @Project: SpringBootDemo
 * @ClassName MyServletContextListener
 * @description: ApplicationListener 增加监听事件
 * @author: leospiritlee
 * @create: 2020-05-21 21:29
 **/
@Component
public class MyServletContextListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();

        UserEventService userEventService = applicationContext.getBean(UserEventService.class);
        User user = userEventService.getUser();

        ServletContext servletContext = applicationContext.getBean(ServletContext.class);
        servletContext.setAttribute("user", user);
    }
}
