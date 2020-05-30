package com.leospiritlee.springBootDemo.cache;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project: SpringBootDemo
 * @ClassName MutexService
 * @description: 互斥锁
 * @author: leospiritlee
 * @create: 2020-05-30 11:25
 **/
@Service
public class MutexService {


    public String getData(String key) throws InterruptedException {

        String result = this.getDataFromRedis(key);

        if(StringUtils.isEmpty(result)){
            Lock lock = new ReentrantLock();
            try {

                if(lock.tryLock()){

                    result = this.getDataFromDb(key);
                    if(!StringUtils.isEmpty(result)){
                        this.setDataToRedis(key, result);
                    }
                }else {
                    Thread.sleep(100);
                    result = getData(key);
                }

            }finally {
                lock.unlock();
            }

        }



        return result;
    }


    /**
     *  模拟从db获取数据 不需要实现
     * @param key
     * @return
     */
    private String getDataFromDb(String key){
        return null;
    }

    /**
     *  模拟从redis获取数据 不需要实现
     * @param key
     * @return
     */
    private String getDataFromRedis(String key){

        return null;
    }

    /**
     *  模拟将缓存添加到redis 不需要实现
     * @param key
     * @param result
     */
    private void setDataToRedis(String key, String result){

    }
}
