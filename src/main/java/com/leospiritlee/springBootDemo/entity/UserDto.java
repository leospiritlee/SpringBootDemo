package com.leospiritlee.springBootDemo.entity;

import lombok.Data;

/**
 * @Project: SpringBootDemo
 * @ClassName User
 * @description: user dto 实体
 * @author: leospiritlee
 * @create: 2020-05-19 21:45
 **/
@Data
public class UserDto {
    private String username;
    private String password;
}
