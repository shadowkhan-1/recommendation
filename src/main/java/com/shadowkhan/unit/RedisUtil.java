package com.shadowkhan.unit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private  StringRedisTemplate stringRedisTemplate;

    /**
     * 新增一个字符串类型的值,key是键，value是值。
     *
     * set(K key, V value)
     */
    public void set(String key, String values) {
        // 存入永久数据
//        stringRedisTemplate.opsForValue().set("test2", "1");
        // 也可以向redis里存入数据和设置缓存时间
        stringRedisTemplate.opsForValue().set(key, values, 60, TimeUnit.SECONDS);
    }

    /**
     * 获取值,key不存在返回null
     *
     * get(Object key)
     */
    public  String get(String key) {
        return  stringRedisTemplate.opsForValue().get(key);
    }

}
