package com.leospiritlee.springBootDemo.controller;

import com.leospiritlee.springBootDemo.dto.base.JsonResult;
import com.leospiritlee.springBootDemo.enums.BusinessMsgEnum;
import com.leospiritlee.springBootDemo.exceptions.BusinessErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Project: SpringBootDemo
 * @ClassName ExceptionController
 * @description: 异常处理测试controller
 * @author: leospiritlee
 * @create: 2020-05-17 19:52
 **/
@RestController
@RequestMapping("/exception")
@Slf4j
public class ExceptionController {

    @PostMapping("/test")
    public JsonResult<Void> test(@RequestParam("name")String name, @RequestParam("pass")String pass){
        log.info("receive request name : {}", name);
        log.info("receive request pass : {}", pass);
        return new JsonResult<>();
    }

    @PostMapping("/testNull")
    public JsonResult<Void> testNull(){
        log.info("test NullPointException.");
        throw new NullPointerException();
    }

    @PostMapping("/tesBusiness")
    public JsonResult<Void> tesBusiness(){
        log.info("test BusinessErrorException.");
        throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
    }

}
