package com.leospiritlee.springBootDemo.config;

import com.leospiritlee.springBootDemo.dto.base.JsonResult;
import com.leospiritlee.springBootDemo.exceptions.BusinessErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @Project: SpringBootDemo
 * @ClassName GlobalExceptionHandler
 * @description: 统一异常处理
 * @author: leospiritlee
 * @create: 2020-05-17 19:48
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public JsonResult<Void> handleHttpMessageNotReadableException(MissingServletRequestParameterException ex){
        log.error("req missing required param : {}", ex.getMessage());
        return new JsonResult<>("400", "请求缺少必要参数");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<Void> handleTypeMismatchException(NullPointerException ex){
        log.error("null point exception, {}", ex.getMessage());
        return new JsonResult<>("500", "空指针异常");
    }


    @ExceptionHandler(BusinessErrorException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult<Void> handleTypeBusinessErrorException(BusinessErrorException ex){
        log.error("businessErrorException,{},{}", ex.getCode(), ex.getMsg());
        String code = ex.getCode();
        String msg = ex.getMsg();
        return new JsonResult<>(code, msg);
    }

}
