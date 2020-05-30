package com.leospiritlee.springBootDemo.controller;

import com.leospiritlee.springBootDemo.dto.TestCacheObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @Project: SpringBootDemo
 * @ClassName RedisCacheController
 * @description: redis 缓存测试 controller
 * @author: leospiritlee
 * @create: 2020-05-30 09:45
 **/
@RestController
@RequestMapping("/redisCache")
@Slf4j
public class RedisCacheController {

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/test")
    public void testRedisCache(){
        redisCacheTemplate.opsForValue().set(
                "testCache",
                new TestCacheObj(1, "test-key", "test-value")
        );

        String testCacheObj = redisTemplate.opsForValue().get("testCache");
        TestCacheObj testCacheObj1 = (TestCacheObj) redisCacheTemplate.opsForValue().get("testCache");
        log.info("testCache: {}", testCacheObj);
        log.info("testCacheObj1: {}", testCacheObj1.toString());
    }
}
