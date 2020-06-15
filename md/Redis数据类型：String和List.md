# 		Redis数据类型：String



```sql
127.0.0.1:6379> set key1 v1  --设置值
OK
127.0.0.1:6379> get key1 --取值
"v1"
127.0.0.1:6379> keys* 
(error) ERR unknown command 'keys*'
127.0.0.1:6379> keys * --显示所有key
1) "key1"
127.0.0.1:6379> exists key1 --判断存在key
(integer) 1
127.0.0.1:6379> append key1 "ok0" --忘字符串里加值
(integer) 5
127.0.0.1:6379> get key1
"v1ok0"
127.0.0.1:6379> strlen key1 --显示key对应值的长度
(integer) 5
127.0.0.1:6379> set view 0
OK
127.0.0.1:6379> get view
"0"
127.0.0.1:6379> incr view --每次自增加一
(integer) 1
127.0.0.1:6379> get view
"1"
127.0.0.1:6379> decr view --每次自减减一
(integer) 0
127.0.0.1:6379> decr view
(integer) -1
127.0.0.1:6379> get view
"-1"
127.0.0.1:6379> incrby view 10 --每次自增加10
(integer) 9
127.0.0.1:6379> incrby view 10 
(integer) 19
127.0.0.1:6379> get view
"19"
127.0.0.1:6379>  DECRBY view 5 --每次自减5
```



```sql
127.0.0.1:6379> set key1 "hello,asd"
OK
127.0.0.1:6379> get key1
"hello,asd"
127.0.0.1:6379> getrange key1 0 3 --截取字符串（索引是从0开始的）
"hell"
127.0.0.1:6379> getrange key1 0 -1 -- -1表示显示所有字符
"hello,asd"
127.0.0.1:6379> set key2 adcdefg
OK
127.0.0.1:6379> get key2
"adcdefg"
127.0.0.1:6379> setrange key2 1 xx --替换指定位置开始的字符串
(integer) 7
127.0.0.1:6379> get key2
"axxdefg"
127.0.0.1:6379> setex key3 30 "hello" --设置值的同时设置生效时间
OK
127.0.0.1:6379> setex key3 40 "qweq"
OK
127.0.0.1:6379> get key3
"qweq"
127.0.0.1:6379> ttl key3 --显示剩余时间
(integer) 32
127.0.0.1:6379> setnx key4 60 --如果key存在创建失败，如果key不存在则创建
(integer) 1
127.0.0.1:6379> get key4
"60"
127.0.0.1:6379>
```



```sql
127.0.0.1:6379> dbsize --显示当前数据容量
(integer) 4
127.0.0.1:6379> flushdb --清空当前库
OK
127.0.0.1:6379> dbsize
(integer) 0
127.0.0.1:6379> mset k1 v1 k2 v2 --同时设置多组key-value
OK
127.0.0.1:6379> mget k1 k2 --同时取到多组key
1) "v1"
2) "v2"
127.0.0.1:6379> msetnx k3 v3 k1 v1 --msetnx是一个原子性操作，要么一起成功，要么一起失败
(integer) 0
127.0.0.1:6379> msetnex k3 v3 k4 v4
(error) ERR unknown command 'msetnex'
127.0.0.1:6379> msetnx k3 v3 k4 v4
(integer) 1
127.0.0.1:6379> set user:1 {name:zhangsan,age:3} --以json的方式保存对象
OK
127.0.0.1:6379> get user
(nil)
127.0.0.1:6379> get user:1
"{name:zhangsan,age:3}"
127.0.0.1:6379> mset user:2:name wangsi user:2:age 2 --另一种存储对象方式user:{id}:{field}
OK
127.0.0.1:6379> mget user:2:name user:2:age
1) "wangsi"
2) "2"
127.0.0.1:6379> getset v9 name --先get再set
(nil)
127.0.0.1:6379> get v9
"name"
127.0.0.1:6379>
```

**String类似的使用场景：value除了是我们的字符串还可以是我们的数字**

- 计数器
- 统计多单位的数量
- 粉丝数
- 对象缓存存储



--本文写作时借鉴了狂神这名UP主的视频讲解

