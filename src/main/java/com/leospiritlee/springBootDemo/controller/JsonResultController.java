package com.leospiritlee.springBootDemo.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.leospiritlee.springBootDemo.dto.User;
import com.leospiritlee.springBootDemo.dto.base.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Project: SpringBootDemo
 * @ClassName JsonResultController
 * @description: 统一封装格式
 * @author: leospiritlee
 * @create: 2020-05-14 22:10
 **/
@RestController
@RequestMapping("/jsonResult")
public class JsonResultController {

    /**
     *  user dto json 返回测试
     * @return
     */
    @GetMapping("/getUser")
    public JsonResult<User> getUser(){
        return new JsonResult<>(new User(1L, "Jim", "123456"));
    }

    /**
     *  list user dto json 返回测试
     * @return
     */
    @GetMapping("/getUserList")
    public JsonResult<List<User>> getUserList(){
        User user_1 = new User(1L, "Jim", "123456");
        User user_2 = new User(2L, "Tom", "123456");
        return new JsonResult<>(Lists.newArrayList(user_1, user_2));
    }

    /**
     *  map user dto json 返回测试
     * @return
     */
    @GetMapping("/getUserMap")
    public JsonResult<Map<String, User>> getUserMap(){
        User user_1 = new User(1L, "Jim", "123456");
        User user_2 = new User(2L, "Tom", "123456");

        Map<String, User> userMap = Maps.newHashMap();
        userMap.put("user_1", user_1);
        userMap.put("user_2", user_2);

        return new JsonResult<>(userMap);
    }

}
