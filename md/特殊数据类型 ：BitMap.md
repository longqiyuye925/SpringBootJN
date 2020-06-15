# 特殊数据类型 ：BitMap 

Bitmap数据结构是采用二进制来进行记录，就只有0 和 2两个状态

```bash
127.0.0.1:6379> setbit sign x 0
(error) ERR bit offset is not an integer or out of range
127.0.0.1:6379> setbit sign 0 0 # 设置一个map（sign） 状态为0
(integer) 0
127.0.0.1:6379> setbit sign 1 0
(integer) 0
127.0.0.1:6379> getbit sign 1
(integer) 0
127.0.0.1:6379> setbit sign 2 1 # 忘map塞入一个bit 状态为1
(integer) 0
127.0.0.1:6379> getbit sign 2
(integer) 1
127.0.0.1:6379> bitcount sign
(integer) 1
127.0.0.1:6379> setbit sign 3 0
(integer) 0
127.0.0.1:6379> setbit sign 4 0
(integer) 0
127.0.0.1:6379> bitcount sign
(integer) 1
127.0.0.1:6379> setbit sign 5 0
(integer) 0
127.0.0.1:6379> setbit sign 6 0
(integer) 0
127.0.0.1:6379> bitcount sign #上面可以看到一共塞入一个状态1，其他都是0，所以统计数量是1
(integer) 1
127.0.0.1:6379> setbit sign 7 0
(integer) 0
127.0.0.1:6379> setbit sign 8
(error) ERR wrong number of arguments for 'setbit' command
127.0.0.1:6379> setbit sign 8 0
(integer) 0
127.0.0.1:6379> bitcount sign
(integer) 1
127.0.0.1:6379> setbit sign 9 1
(integer) 0
127.0.0.1:6379> bitcount sign
(integer) 2
127.0.0.1:6379> setbit sign 10 2
(error) ERR bit is not an integer or out of range
127.0.0.1:6379> setbit sign 10 1
(integer) 0
127.0.0.1:6379> bitcount sign
(integer) 3
127.0.0.1:6379>

```

这种数据类型可以用于统计每天重复的只有两种结果的事，比如统计打卡，1代表打卡，0代表没打卡，最后统计数量