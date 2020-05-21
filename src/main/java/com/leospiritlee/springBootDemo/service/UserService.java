package com.leospiritlee.springBootDemo.service;

import com.leospiritlee.springBootDemo.entity.UserDto;

import java.util.List;

/**
 * @Project: SpringBootDemo
 * @ClassName UserService
 * @description: userService
 * @author: leospiritlee
 * @create: 2020-05-19 22:36
 **/
public interface UserService {

    UserDto getUser(Long id);

    List<UserDto> getAll();

    UserDto getUserByName(String username);

    UserDto getUser(Long id, String username);

    Integer insertUser(UserDto userDto);

}
