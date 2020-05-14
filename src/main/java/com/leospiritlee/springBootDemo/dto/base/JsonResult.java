package com.leospiritlee.springBootDemo.dto.base;

import lombok.Data;

/**
 * @Project: SpringBootDemo
 * @ClassName JsonResult
 * @description: 统一json返回格式
 * @author: leospiritlee
 * @create: 2020-05-14 22:01
 **/
@Data
public class JsonResult<T> {

    private T data;
    private String code;
    private String msg;


    public JsonResult() {
        this.code = "0";
        this.msg = "成功";
    }

    public JsonResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(T data) {
        this.data = data;
        this.code = "0";
        this.msg = "成功";
    }

    public JsonResult(T data, String code) {
        this.data = data;
        this.code = code;
        this.msg = "成功";
    }


    public JsonResult(T data, String code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }
}
