package com.leospiritlee.springBootDemo.controller;

import com.leospiritlee.springBootDemo.cache.TestCacheObjService;
import com.leospiritlee.springBootDemo.dto.TestCacheObj;
import com.leospiritlee.springBootDemo.dto.base.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: SpringBootDemo
 * @ClassName SpringCacheController
 * @description: spring 缓存测试
 * @author: leospiritlee
 * @create: 2020-05-30 10:08
 **/
@RestController
@RequestMapping("/springCache")
@Slf4j
public class SpringCacheController {

    @Autowired
    private TestCacheObjService testCacheObjService;

    @PostMapping("/add")
    public JsonResult<TestCacheObj> add(@RequestBody TestCacheObj testCacheObj){
        testCacheObjService.save(testCacheObj);
        log.info("add testCacheObj success. {}", testCacheObj.toString());
        return new JsonResult<>(testCacheObj);
    }

    @GetMapping("/del/{id}")
    public JsonResult<Void> del(@PathVariable Integer id){
        testCacheObjService.delete(id);
        log.info("del testCacheObj success. {}",id);
        return new JsonResult<>();
    }

    @GetMapping("/get/{id}")
    public JsonResult<TestCacheObj> get(@PathVariable Integer id){
        TestCacheObj testCacheObj = testCacheObjService.get(id);
        log.info("get testCacheObj success. {}", testCacheObj);
        return new JsonResult<>(testCacheObj);
    }

}
