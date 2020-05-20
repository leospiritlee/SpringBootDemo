package com.leospiritlee.springBootDemo.controller;

import com.leospiritlee.springBootDemo.dto.base.JsonResult;
import com.leospiritlee.springBootDemo.entity.User;
import com.leospiritlee.springBootDemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Project: SpringBootDemo
 * @ClassName MyBatisController
 * @description: MyBatis测试controller
 * @author: leospiritlee
 * @create: 2020-05-19 21:47
 **/
@RestController
@RequestMapping("/myBatis")
public class MyBatisController {

    @Resource
    private UserService userService;

    @GetMapping("/getUserByName/{username}")
    public JsonResult<User> getUserByName(@PathVariable String username){
        return new JsonResult<>(
                userService.getUserByName(username)
        );
    }

    @GetMapping("/getAll")
    public JsonResult<List<User>> getAll(){
        return new JsonResult<>(
                userService.getAll()
        );
    }

    @GetMapping("/getUserById/{id}")
    public JsonResult<User> getUserById(@PathVariable Long id){
        return new JsonResult<>(
                userService.getUser(id)
        );
    }

    @GetMapping("getUser/{id}/{username}")
    public JsonResult<User> getUserByNameAndId(@PathVariable Long id, @PathVariable String username){
        return new JsonResult<>(
                userService.getUser(id, username)
        );
    }

    @PostMapping("/insert")
    public JsonResult<Void> insertUser(@RequestBody User user){
        userService.insertUser(user);
        return new JsonResult<>();
    }

}
