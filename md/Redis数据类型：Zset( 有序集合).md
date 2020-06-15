# Redis数据类型：Zset( 有序集合)

Zset是set的基础上加了有序

```bash
127.0.0.1:6379> zadd myset 1 one 2 two 5 five
(integer) 3 #添加元素
127.0.0.1:6379> zrange myset
(error) ERR wrong number of arguments for 'zrange' command
127.0.0.1:6379> zrange myset 0 -1 #获取元素
1) "one"
2) "two"
3) "five"
127.0.0.1:6379> zadd salary 2500 xiaohong
(integer) 1
127.0.0.1:6379> zadd salary 5000 panghu
(integer) 1
127.0.0.1:6379> zadd salary 7000 daxiong
(integer) 1
127.0.0.1:6379> zadd salary 1000 jingxiang
(integer) 1
127.0.0.1:6379> zrangebyscore salary -inf +inf
1) "jingxiang"    #从小到大排序
2) "xiaohong"
3) "panghu"
4) "daxiong"
127.0.0.1:6379> zrangebyscore salary -inf +inf withscores  #从小到大排序 并显示工资
1) "jingxiang"
2) "1000"
3) "xiaohong"
4) "2500"
5) "panghu"
6) "5000"
7) "daxiong"
8) "7000"
127.0.0.1:6379> zrangebyscore salary -inf 4000 withscores #从小到大排序 限制右范围
1) "jingxiang"
2) "1000"
3) "xiaohong"
4) "2500"
127.0.0.1:6379> zrem salary daxiong #删除某个元素
(integer) 1
127.0.0.1:6379> zrange salary 0 -1
1) "jingxiang"
2) "xiaohong"
3) "panghu"
127.0.0.1:6379> zcard salary #显示key里面的元素数量
(integer) 3
127.0.0.1:6379> zcount salary 1000 5000 #显示key在指定范围的数量
(integer) 3
127.0.0.1:6379> zcount salary 0 3000
(integer) 2
127.0.0.1:6379>
```

**案例：**

**set 排序 存储班级成绩表  工资表排序**

**普通消息 1 重要消息2 带权重判断**

**销量排行版**