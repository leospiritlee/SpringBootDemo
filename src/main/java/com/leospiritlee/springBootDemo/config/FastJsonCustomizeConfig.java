package com.leospiritlee.springBootDemo.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @Project: SpringBootDemo
 * @ClassName FastJsonCustomizeConfig
 * @description:  fastJson 配置config
 * @author: leospiritlee
 * @create: 2020-05-14 21:51
 **/
@Configuration
public class FastJsonCustomizeConfig extends WebMvcConfigurationSupport{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
                "classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();

        config.setSerializerFeatures(
                //保留map空自断
                SerializerFeature.WriteMapNullValue,
                //将String类型的null转化成""
                SerializerFeature.WriteNullStringAsEmpty,
                //将Number类型的null转化成0
                SerializerFeature.WriteNullNumberAsZero,
                //将List类型的null转化成[]
                SerializerFeature.WriteNullListAsEmpty,
                //将Boolean类型的null转化成false
                SerializerFeature.WriteNullBooleanAsFalse,
                //避免循环引用
                SerializerFeature.DisableCircularReferenceDetect
        );

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));

        List<MediaType> mediaTypeList = Lists.newArrayList();
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);

        converters.add(converter);
    }
}
