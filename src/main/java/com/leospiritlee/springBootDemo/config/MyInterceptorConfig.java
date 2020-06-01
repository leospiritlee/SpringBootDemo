package com.leospiritlee.springBootDemo.config;

import com.leospiritlee.springBootDemo.interceptors.MyInterceptors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Project: SpringBootDemo
 * @ClassName MyInterceptorConfig
 * @description: 自定义拦截器配置
 * @author: leospiritlee
 * @create: 2020-06-01 21:48
 * @see FastJsonCustomizeConfig 冲突 共同继承了 WebMvcConfigurationSupport
 **/
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptors myInterceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptors).addPathPatterns("/interceptor/**");
    }
}
