package com.bjsxt.springbootdemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

@SpringBootTest
class SpringbootdemoApplicationTests {

    @Test
    void contextLoads() {
        //
    }

    /*
     * 测试redis的事务
     */
    @Test
    void testTransaction() {
        //建立连接
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.connect();
        //开启事务
        Transaction multi = jedis.multi();
        //僿值
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "wushichao");
        String str = jsonObject.toJSONString();
        try {
            multi.set("wsc", str);
            //执行
            multi.exec();
        } catch (Exception e) {
            e.printStackTrace();
            //异常就取消事务
            multi.discard();
        } finally {
            jedis.close();
        }
    }
}
