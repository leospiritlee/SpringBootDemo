package com.leospiritlee.springBootDemo.controller;

import com.leospiritlee.springBootDemo.anotations.UnInterception;
import com.leospiritlee.springBootDemo.dto.base.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: SpringBootDemo
 * @ClassName InterceptorController
 * @description: 拦截器测试
 * @author: leospiritlee
 * @create: 2020-06-01 21:50
 **/
@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/test")
    public JsonResult<Void> test(){
        return new JsonResult<Void>();
    }

    @GetMapping("/testUn")
    @UnInterception
    public JsonResult<Void> testUnInterception(){
        return new JsonResult<Void>();
    }

}
