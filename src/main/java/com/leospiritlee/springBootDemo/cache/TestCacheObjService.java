package com.leospiritlee.springBootDemo.cache;

import com.leospiritlee.springBootDemo.dto.TestCacheObj;

public interface TestCacheObjService {

    TestCacheObj save(TestCacheObj testCacheObj);
    void delete(int id);
    TestCacheObj get(Integer id);
}
