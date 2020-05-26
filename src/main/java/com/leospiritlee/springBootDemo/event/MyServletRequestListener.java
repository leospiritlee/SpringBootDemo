package com.leospiritlee.springBootDemo.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @Project: SpringBootDemo
 * @ClassName MyServletRequestListener
 * @description: servlet request 监听
 * @author: leospiritlee
 * @create: 2020-05-26 22:04
 **/
@Component
@Slf4j
public class MyServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
        log.info("session id为：{}", httpServletRequest.getRequestedSessionId());
        log.info("request url为：{}", httpServletRequest.getRequestURL());

        httpServletRequest.setAttribute("name","test");

    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("request end.");
        HttpServletRequest httpServletRequest = (HttpServletRequest) sre.getServletRequest();
        log.info("request域中保存的name值为：{}", httpServletRequest.getAttribute("name"));
    }
}
