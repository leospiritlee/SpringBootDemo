package com.leospiritlee.springBootDemo.controller;

import com.leospiritlee.springBootDemo.dto.User;
import com.leospiritlee.springBootDemo.service.UserEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @Project: SpringBootDemo
 * @ClassName ListenerController
 * @description: 监听测试
 * @author: leospiritlee
 * @create: 2020-05-21 21:32
 **/
@RestController
@RequestMapping("/listen")
@Slf4j
public class ListenerController {

    @Autowired
    private UserEventService userEventService;

    @GetMapping("/getUser")
    public User getUser(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        return (User) servletContext.getAttribute("user");
    }

    @GetMapping("/getOnlineCount")
    public String getTotalUser(HttpServletRequest request){
        Integer count =  (Integer) request.getSession().getServletContext().getAttribute("count");
        return "now online count:".concat(count.toString());
    }

    @GetMapping("/getRequest")
    public String getRequest(HttpServletRequest request){
        log.info("servletRequestListener  init name is : {}", request.getAttribute("name"));
        return "success";
    }

    @GetMapping("/getMyEvent")
    public String getMyEvent(HttpServletRequest request){
        userEventService.getUser2();
        return "success";
    }

}
