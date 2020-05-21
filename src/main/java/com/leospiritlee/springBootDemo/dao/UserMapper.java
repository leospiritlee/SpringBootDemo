package com.leospiritlee.springBootDemo.dao;

import com.leospiritlee.springBootDemo.entity.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDto getUserByName(String username);

    @Select("select * from user where id = #{id}")
    @Results({
        @Result(property = "username", column = "user_name"),
        @Result(property = "password", column = "password")
    })
    UserDto getUser(Long id);

    @Select("select * from user")
    List<UserDto> getAll();

    @Select("select * from user where id = #{id} and user_name=#{name}")
    UserDto getUserByIdAndName(@Param("id") Long id, @Param("name") String username);


    @Insert("insert into user (user_name, password) values (#{username}, #{password})")
    Integer insertUser(UserDto userDto);
}
