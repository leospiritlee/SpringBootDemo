package com.leospiritlee.springBootDemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

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


    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint){
        log.info("-----------doBefore----------------");

        Signature signature = joinPoint.getSignature();

        String declaringTypeName = signature.getDeclaringTypeName();

        String methodName = signature.getName();

        log.info("execute method: {}, belong package:{}", methodName, declaringTypeName);

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attributes.getRequest();

        String url = request.getRequestURL().toString();

        String ip = request.getRemoteAddr();

        log.info("request url: {}, id : {}", url, ip);

    }

    @After("pointCut()")
    public void doAfter(JoinPoint joinPoint){
        log.info("-----------doAfter----------------");

        Signature signature = joinPoint.getSignature();

        String methodName = signature.getName();

        log.info("method: {} executed finish", methodName);
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void doAfterReturning(JoinPoint joinPoint, Object result){

        Signature signature = joinPoint.getSignature();

        String methodName = signature.getName();

        log.info("method: {} executed finish, return obj: {}", methodName, result);
        log.info("added result : {}", result + "-extra");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "ex")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable ex){

        Signature signature = joinPoint.getSignature();

        String methodName = signature.getName();

        log.info("method: {} execute exception.", methodName, ex);
    }

}


