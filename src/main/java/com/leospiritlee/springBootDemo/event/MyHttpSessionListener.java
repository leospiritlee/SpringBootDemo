package com.leospiritlee.springBootDemo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Project: SpringBootDemo
 * @ClassName MyHttpSessionListener
 * @description: http 监听
 * @author: leospiritlee
 * @create: 2020-05-21 22:34
 **/
@Component
@Slf4j
public class MyHttpSessionListener implements HttpSessionListener {

    public Integer count = 0;




    @Override
    public synchronized void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("on online");
        count++;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);

    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("offline");
        count--;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);

    }
}


