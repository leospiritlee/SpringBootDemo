package com.leospiritlee.springBootDemo.controller;

import com.leospiritlee.springBootDemo.dto.User;
import com.leospiritlee.springBootDemo.dto.base.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: SpringBootDemo
 * @ClassName Test2Controller
 * @description: dto 请求响应测试controller
 * @author: leospiritlee
 * @create: 2020-05-17 19:32
 **/
@RestController
@RequestMapping("/test2")
@Api(value = "swagger2接口文档")
@Slf4j
public class Test2Controller {


    @GetMapping("/get/{id}")
    @ApiOperation(value = "通过用户唯一ID 查询指定用户")
    public JsonResult<User> getUserInfo(@PathVariable @ApiParam(value = "用户唯一ID") Long id){
        log.info("receive request id: {}", id);
        return new JsonResult<>(new User(1L,"zhangsan", "123456"));
    }


    @PostMapping("/insert")
    @ApiOperation(value = "user新增")
    public JsonResult<Void> insertUser(@RequestBody @ApiParam(value = "用户请求信息")User user){
        log.info("receive request user: {}", user.toString());
        return new JsonResult<>();
    }
}
