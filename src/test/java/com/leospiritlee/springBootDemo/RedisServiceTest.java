package com.leospiritlee.springBootDemo;

import com.alibaba.fastjson.JSON;
import com.leospiritlee.springBootDemo.dto.User;
import com.leospiritlee.springBootDemo.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Project: SpringBootDemo
 * @ClassName RedisServiceTest
 * @description: TODO
 * @author: leospiritlee
 * @create: 2020-06-14 15:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(RedisServiceTest.class);

    @Resource
    private RedisService redisService;


    @Test
    public void redisTestString(){
        redisService.setString("testKey", "testValue");
        logger.info("testKey: value : {}", redisService.getString("testKey"));

        User user = new User();
        user.setId(1L);
        user.setUserName("zhangsan");
        user.setPassword("123456");

        redisService.setString("user", JSON.toJSONString(user));
        logger.info("user-info:{}", redisService.getString("user"));
    }

    @Test
    public void redisTestHash(){

        String key = "hashKey";
        String fieldKey = "hashFieldKey";
        String value = "hashValue";

        redisService.setHash(key, fieldKey, value);

        logger.info("hashKey: {}, fieldKey: {}, value: {}", key, fieldKey, redisService.getHash(key, fieldKey));

    }

    @Test
    public void redisTestList(){
        String key = "listKey";
        String value_1 = "listValue_1";
        String value_2 = "listValue_2";

        Long result_1 = redisService.setList(key, value_1);
        Long result_2 = redisService.setList(key, value_2);

        logger.info("result_1: {}", result_1);
        logger.info("result_2: {}", result_2);

        logger.info("listValue: {}", redisService.getList(key, 0 ,1));
    }


}
