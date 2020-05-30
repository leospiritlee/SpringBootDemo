package com.leospiritlee.springBootDemo.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Project: SpringBootDemo
 * @ClassName TestCacheObj
 * @description: redis测试缓存对象
 * @author: leospiritlee
 * @create: 2020-05-30 09:32
 **/
@Data
@ToString
public class TestCacheObj implements Serializable {

    private static final long serialVersionUID = 1616611450716146664L;
    private Integer id;
    private String key;
    private String value;

    public TestCacheObj(Integer id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }

    public TestCacheObj() {
    }
}
