package com.leospiritlee.springBootDemo.controller;

import com.leospiritlee.springBootDemo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/test", produces = "application/json; charset=UTF-8")
public class TestController {

    private final static Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     *  get 请求测试
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String testGet(){
        return "success";
    }

    @GetMapping("/user/{id}")
    public String testPathVariable(@PathVariable Integer id){
        logger.info("receive request id : {}", id);
        return "success";
    }

    @GetMapping("/user2/{idd}")
    public String testPathVariable2(@PathVariable(value = "idd") Integer id){
        logger.info("receive request id : {}", id);
        return "success";
    }

    @GetMapping("/user/{id}/{name}")
    public String testPathVariable(@PathVariable Integer id, @PathVariable String name){
        logger.info("receive request id : {}", id);
        logger.info("receive request name : {}", name);
        return "success";
    }

    @GetMapping("/user")
    public String testRequestParam(@RequestParam Integer id){
        logger.info("receive request id : {}", id);
        return "success";
    }

    @GetMapping("/user2")
    public String testRequestParam2(@RequestParam(value = "idd", required = false)Integer id){
        logger.info("receive request id : {}", id);
        return "success";
    }

    @PostMapping("/form")
    public String testForm(@RequestParam String userName, @RequestParam String password){
        logger.info("receive request userName : {}", userName);
        logger.info("receive request password : {}", password);
        return "success";
    }

    @PostMapping("/form2")
    public String testForm2(@RequestBody User user){
        logger.info("receive user dto : {}", user.toString());
        return "success";
    }

}
