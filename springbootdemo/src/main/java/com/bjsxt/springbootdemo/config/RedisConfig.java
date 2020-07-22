package com.bjsxt.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Description:
 * @author: zf
 * @Param:
 * @Return:
 * @Date: 2020 07 2020/7/16
 */

@Configuration
public class RedisConfig {
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String,Object>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        //STRING的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //key的序列化采用String类型的
        redisTemplate.setKeySerializer(stringRedisSerializer);
        //hash的key也采用String类型
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        //value采用jackson类型
        //redisTemplate.setValueSerializer();
        return redisTemplate;
    }
}