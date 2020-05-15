package com.leospiritlee.springBootDemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: SpringBootDemo
 * @ClassName TestLogController
 * @description: 日志输出测试controller
 * @author: leospiritlee
 * @create: 2020-05-15 10:34
 **/
@RestController
@RequestMapping("/test")
public class TestLogController {


    private final static Logger logger = LoggerFactory.getLogger(TestLogController.class);

    /**
     *  log level级别测试
     * @return
     */
    @GetMapping("/log")
    public String testLog(){

        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");

        logger.info("test: {} , {} ", "1", "2");

        return "success";
    }

}
