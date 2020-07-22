package com.bjsxt.springbootdemo.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 07 2020/7/19
 */
@Component
public class RedisUtil {
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    public String getString(String Str) {
        return redisTemplate.opsForValue().get(Str).toString();
    }

    public Boolean setex(String key, String value) {
        try {
            redisTemplate.opsForValue().setIfAbsent(key, value, 60, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
