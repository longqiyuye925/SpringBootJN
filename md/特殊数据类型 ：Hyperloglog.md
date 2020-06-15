# 特殊数据类型 ：**Hyperloglog** 

```bash
127.0.0.1:6379> flushall
OK
127.0.0.1:6379> pfadd key1 a b c d e f #添加元素
(integer) 1
127.0.0.1:6379> pfadd key2 q w e r t y
(integer) 1
127.0.0.1:6379> pfcount key1 #统计元素数量
(integer) 6
127.0.0.1:6379> pfcount key2
(integer) 6
127.0.0.1:6379> pfmerge key3 key1 key2 #对key1 key2取并集
OK
127.0.0.1:6379> pfcount key3
(integer) 11
127.0.0.1:6379>
```

**Hyperloglog** 数据类型的好处，它占用内存固定，只有12KB。

如果是为了统计网站来过的人数（A来多次还是代表一人），同时接受数值错误率（0.81%），可以使用这个数据类型

如果不接受，那么可以使用set类型，把用户ID存进去，然后求数据量，但是这样用户多了，占用内存比较大