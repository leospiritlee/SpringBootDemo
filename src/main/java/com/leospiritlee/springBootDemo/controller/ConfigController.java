package com.leospiritlee.springBootDemo.controller;

import com.leospiritlee.springBootDemo.config.MicroServiceUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @Project: SpringBootDemo
 * @ClassName ConfigController
 * @description: 配置文件参数读取测试controller
 * @author: leospiritlee
 * @create: 2020-05-15 11:07
 **/
@RestController
@RequestMapping("/config")
public class ConfigController {

    private final static Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Value("${business.orderQueryUrl}")
    private String orderQueryUrl;

    @Resource
    private MicroServiceUrl microServiceUrl;


    /**
     *  读取配置文件测试
     * @return
     */
    @GetMapping("/loadConfig")
    public String testLoadConfig(){
        logger.info("load order query url : {}", orderQueryUrl);
        return "success";
    }

    /**
     *  读取配置文件测试
     * @return
     */
    @GetMapping("/loadConfigs")
    public String testLoadConfigs(){

        logger.info("load OrderQueryUrl : {}", microServiceUrl.getOrderQueryUrl());
        logger.info("load UserQueryUrl : {}", microServiceUrl.getUserQueryUrl());
        logger.info("load ShoppingQueryUrl : {}", microServiceUrl.getShoppingQueryUrl());

        return "success";
    }


}
