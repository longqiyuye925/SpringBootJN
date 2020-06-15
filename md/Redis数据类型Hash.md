# Redis数据类型:Hash

```bash
127.0.0.1:6379> dbsize
(integer) 11
127.0.0.1:6379> keys *
 1) "user:2:age"
 2) "k3"
 3) "v9"
 4) "k4"
 5) "user:2:name"
 6) "k1"
 7) "k2"
 8) "my123"
 9) "key"
10) "key2"
11) "user:1"
127.0.0.1:6379> flushtable
(error) ERR unknown command 'flushtable'
127.0.0.1:6379> flushall
OK
127.0.0.1:6379> dbsize
(integer) 0
127.0.0.1:6379> hset myhash field1 kuangsan #塞入值
(integer) 1
127.0.0.1:6379> hget myhash field1 
"kuangsan" #取得某个hash的某个字段值
127.0.0.1:6379> hmset myhash field2 hello field world #塞入多个值
OK
127.0.0.1:6379> hgetall myhash #获得key的所有hash值
1) "field1"
2) "kuangsan"
3) "field2"
4) "hello"
5) "field"
6) "world"
127.0.0.1:6379> hdel myhash field1
(integer) 1
127.0.0.1:6379> hgetall myhash
1) "field2"
2) "hello"
3) "field"
4) "world"
127.0.0.1:6379> hlen myhash #取得hash的key的长度
(integer) 2
127.0.0.1:6379> hexists myhahs field1 #判断hash是否存在
(integer) 0
127.0.0.1:6379> hexists myhash field1
(integer) 0
127.0.0.1:6379> hexists myhash field
(integer) 1
127.0.0.1:6379> hkeys myhash #显示所有的key
1) "field2"
2) "field"
127.0.0.1:6379> hvals myhash #显示所有的value
1) "hello"
2) "world"
127.0.0.1:6379> hset myhash field3 1 
(integer) 1
127.0.0.1:6379> hincrby myhash field3 1 #指定增量
(integer) 2
127.0.0.1:6379> hincrby myhash field3 -1 
(integer) 1
127.0.0.1:6379> hsetnx myhash field4 hello # 如果不存在则可以设置
(integer) 1
127.0.0.1:6379> hsetnx myhash field4 world
(integer) 0
127.0.0.1:6379>
```

**hash更适合存储对象，String更适合存储字符串**

