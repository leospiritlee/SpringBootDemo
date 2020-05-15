package com.leospiritlee.springBootDemo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Project: SpringBootDemo
 * @ClassName MicroServiceUrl
 * @description: 封装配置读取组件
 * @author: leospiritlee
 * @create: 2020-05-15 11:11
 **/
@Component
@ConfigurationProperties(prefix = "business")
public class MicroServiceUrl {

    private String orderQueryUrl;
    private String userQueryUrl;
    private String shoppingQueryUrl;

    public String getOrderQueryUrl() {
        return orderQueryUrl;
    }

    public void setOrderQueryUrl(String orderQueryUrl) {
        this.orderQueryUrl = orderQueryUrl;
    }

    public String getUserQueryUrl() {
        return userQueryUrl;
    }

    public void setUserQueryUrl(String userQueryUrl) {
        this.userQueryUrl = userQueryUrl;
    }

    public String getShoppingQueryUrl() {
        return shoppingQueryUrl;
    }

    public void setShoppingQueryUrl(String shoppingQueryUrl) {
        this.shoppingQueryUrl = shoppingQueryUrl;
    }
}
