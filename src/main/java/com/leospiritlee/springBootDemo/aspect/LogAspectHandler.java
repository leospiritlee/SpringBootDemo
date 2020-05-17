package com.leospiritlee.springBootDemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Project: SpringBootDemo
 * @ClassName LogAspectHandler
 * @description: 日志切面handler
 * @author: leospiritlee
 * @create: 2020-05-17 20:58
 **/
@Aspect
@Component
@Slf4j
public class LogAspectHandler {

    @Pointcut("execution(* com.leospiritlee.springBootDemo.controller..*.*(..))")
    public void pointCut(){
        log.info("pointCut....");
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void annotationCut(){
        log.info("annotationCut....");
    }
}


