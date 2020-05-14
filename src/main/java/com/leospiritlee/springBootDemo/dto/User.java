package com.leospiritlee.springBootDemo.dto;

import lombok.Data;

/**
 * @Project: SpringBootDemo
 * @ClassName User
 * @description: user dto 模型
 * @author: leospiritlee
 * @create: 2020-05-14 21:21
 **/
@Data
public class User {

    private Long id;
    private String userName;
    private String password;

    public User() {
    }

    public User(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
