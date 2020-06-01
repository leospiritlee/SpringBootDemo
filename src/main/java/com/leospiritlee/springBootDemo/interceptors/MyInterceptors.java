package com.leospiritlee.springBootDemo.interceptors;

import com.leospiritlee.springBootDemo.anotations.UnInterception;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @Project: SpringBootDemo
 * @ClassName MyInterceptors
 * @description: 自定义拦截器
 * @author: leospiritlee
 * @create: 2020-06-01 21:42
 **/
@Component
@Slf4j
public class MyInterceptors implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName = method.getName();
        log.info("-----interceptor method[{}]------ execute before the method is executed.", methodName);

        UnInterception unInterception = method.getAnnotation(UnInterception.class);
        if(null != unInterception){
            log.info("---unInterception start.");
            return true;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("-----execute the method before view rending");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("-----after execute the method then to clean.");
    }
}
