package com.leospiritlee.springBootDemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: SpringBootDemo
 * @ClassName StartController
 * @description: 测试controller
 * @author: leospiritlee
 * @create: 2020-05-14 21:00
 **/
@RestController
@RequestMapping("/start")
public class StartController {

    @RequestMapping(value = "/springBoot", method = RequestMethod.GET)
    public String startSpringBoot(){
        return "start springBoot.";
    }
}
