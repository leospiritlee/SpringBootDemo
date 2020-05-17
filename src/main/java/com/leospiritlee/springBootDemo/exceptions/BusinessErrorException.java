package com.leospiritlee.springBootDemo.exceptions;

import com.leospiritlee.springBootDemo.enums.BusinessMsgEnum;
import lombok.Data;

/**
 * @Project: SpringBootDemo
 * @ClassName BusinessErrorException
 * @description: 自定义业务异常
 * @author: leospiritlee
 * @create: 2020-05-17 20:11
 **/
@Data
public class BusinessErrorException extends RuntimeException{

    private static final long serialVersionUID = -7388235384257249340L;

    private String code;

    private String msg;

    public BusinessErrorException(BusinessMsgEnum businessMsgEnum) {
        this.code = businessMsgEnum.getCode();
        this.msg = businessMsgEnum.getMsg();
    }
}
