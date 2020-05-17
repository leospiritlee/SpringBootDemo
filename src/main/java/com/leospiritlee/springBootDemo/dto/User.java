package com.leospiritlee.springBootDemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Project: SpringBootDemo
 * @ClassName User
 * @description: user dto 模型
 * @author: leospiritlee
 * @create: 2020-05-14 21:21
 **/
@Data
@ApiModel(value = "用户实体类")
public class User {

    @ApiModelProperty(value = "用户唯一ID")
    private Long id;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "用户密码")
    private String password;

    public User() {
    }

    public User(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
