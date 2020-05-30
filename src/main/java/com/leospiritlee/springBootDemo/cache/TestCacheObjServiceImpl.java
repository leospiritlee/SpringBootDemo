package com.leospiritlee.springBootDemo.cache;

import com.google.common.collect.Maps;
import com.leospiritlee.springBootDemo.dto.TestCacheObj;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Project: SpringBootDemo
 * @ClassName TestCacheObjServiceImpl
 * @description: 测试 crud实现
 * @author: leospiritlee
 * @create: 2020-05-30 10:02
 **/
@Service
@Slf4j
public class TestCacheObjServiceImpl implements TestCacheObjService {

    private static Map<Integer, TestCacheObj> testCacheObjMap = Maps.newHashMap();
    static {
        testCacheObjMap.put(1, new TestCacheObj(1, "t1", "v1"));
        testCacheObjMap.put(2, new TestCacheObj(2, "t2", "v2"));
        testCacheObjMap.put(3, new TestCacheObj(3, "t3", "v3"));
    }

    @CachePut(value ="testCacheObj", key = "#testCacheObj.id")
    @Override
    public TestCacheObj save(TestCacheObj testCacheObj) {
        testCacheObjMap.put(testCacheObj.getId(), testCacheObj);
        log.info("save obj: {}", testCacheObj.toString());
        return testCacheObj;
    }

    @CacheEvict(value = "testCacheObj", key = "#id")
    @Override
    public void delete(int id) {
        testCacheObjMap.remove(id);
        log.info("del success , id:{}", id);
    }

    @Cacheable(value = "testCacheObj", key = "#id")
    @Override
    public TestCacheObj get(Integer id) {
        TestCacheObj testCacheObj = testCacheObjMap.get(id);
        log.info("get obj : {}", testCacheObj == null ? null : testCacheObj.toString());
        return testCacheObj;
    }
}
