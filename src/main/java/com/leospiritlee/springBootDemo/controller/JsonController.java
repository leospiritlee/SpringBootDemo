package com.leospiritlee.springBootDemo.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.leospiritlee.springBootDemo.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Project: SpringBootDemo
 * @ClassName JsonController
 * @description: JSON 测试输出controller
 * @author: leospiritlee
 * @create: 2020-05-14 21:25
 **/
@RestController
@RequestMapping("/json")
public class JsonController {

    /**
     *  user dto json 返回测试
     * @return
     */
    @GetMapping("/getUser")
    public User getUser(){
        return new User(1L, "Jim", "123456");
    }

    /**
     *  list user dto json 返回测试
     * @return
     */
    @GetMapping("/getUserList")
    public List<User> getUserList(){
        User user_1 = new User(1L, "Jim", "123456");
        User user_2 = new User(2L, "Tom", "123456");
        return Lists.newArrayList(user_1, user_2);
    }

    /**
     *  map user dto json 返回测试
     * @return
     */
    @GetMapping("/getUserMap")
    public Map<String, User> getUserMap(){
        User user_1 = new User(1L, "Jim", "123456");
        User user_2 = new User(2L, "Tom", "123456");

        Map<String, User> userMap = Maps.newHashMap();
        userMap.put("user_1", user_1);
        userMap.put("user_2", null);

        return userMap;
    }

}


