# 				Redis数据类型：List

**Redis学习准备篇**
[https://blog.csdn.net/longqiyuye925/article/details/106246041](https://blog.csdn.net/longqiyuye925/article/details/106246041) 

**所有的list命令都是l开头的**

```sql
127.0.0.1:6379> lpush list one --将值插入list列表的头部
(integer) 1
127.0.0.1:6379> lpush list two
(integer) 2
127.0.0.1:6379> lpush list three
(integer) 3
127.0.0.1:6379> get list
(error) WRONGTYPE Operation against a key holding the wrong kind of value
127.0.0.1:6379> lrange list 0 -1 --获取list中的值
1) "three"
2) "two"
3) "one"
127.0.0.1:6379> lrange list 0 1
1) "three"
2) "two"
127.0.0.1:6379> rpush list right --从list链表的右边插入一个值
(integer) 4
127.0.0.1:6379> lrange list 0 -1
1) "three"
2) "two"
3) "one"
4) "right"
127.0.0.1:6379> lpop list --从左边移除链表的第一个元素
"three"
127.0.0.1:6379> lrange list 0 -1 
1) "two"
2) "one"
3) "right"
127.0.0.1:6379> rpop list --从右边移除链表的第一个元素
"right"
127.0.0.1:6379> lrange list 0 -1
1) "two"
2) "one"
127.0.0.1:6379> lindex list 1 --通过索引取出链表的值
"one"
127.0.0.1:6379> llen list --返回链表的长度
(integer) 2
127.0.0.1:6379>
```

```sql
127.0.0.1:6379> lrange list 0 -1
1) "two"
2) "one"
127.0.0.1:6379> lpush three
(error) ERR wrong number of arguments for 'lpush' command
127.0.0.1:6379> lpush list three
(integer) 3
127.0.0.1:6379> lpush list three
(integer) 4
127.0.0.1:6379> lrange list 0 -1
1) "three"
2) "three"
3) "two"
4) "one"
127.0.0.1:6379> lrem list 2 three --移除链表指定数量的指定值
(integer) 2
127.0.0.1:6379> lrange list 0 01
1) "two"
2) "one"
127.0.0.1:6379> lrange list 0 -1
1) "two"
2) "one"
127.0.0.1:6379> rpush mylist "hello"
(integer) 1
127.0.0.1:6379> rpush mylist "hello1"
(integer) 2
127.0.0.1:6379> rpush mylist "hello2"
(integer) 3
127.0.0.1:6379> rpush mylist "hello3"
(integer) 4
127.0.0.1:6379> ltrim mylist 1 2 --通过下标索引截取链表的值
OK
127.0.0.1:6379> lrange mylist 0 -1
1) "hello1"
2) "hello2"
127.0.0.1:6379> rpoplpush mylist myotherlist --移除列表中的最后一个元素，将它移动到新的列表中
"hello2"
127.0.0.1:6379> lrange mylist 0 -1
1) "hello1"
127.0.0.1:6379> lrange myotherlist 0 -1
1) "hello2"
127.0.0.1:6379>
```

```sql
127.0.0.1:6379> exists list --判读是否存在
(integer) 1
127.0.0.1:6379> lrange list
(error) ERR wrong number of arguments for 'lrange' command
127.0.0.1:6379> lrange list 0 -1
1) "two"
2) "one"
127.0.0.1:6379> lpush list three
(integer) 3
127.0.0.1:6379> lset list 0 mmm --替换链表中指定索引的指定值
OK
127.0.0.1:6379> lrange list 0 -1
1) "mmm"
2) "two"
3) "one"
127.0.0.1:6379> linsert list before two abc --在指定值的前面插入新值
(integer) 4
127.0.0.1:6379> lrange list 0 -1
1) "mmm"
2) "abc"
3) "two"
4) "one"
127.0.0.1:6379> linsert list after one zx ----在指定值的后面插入新值
(integer) 5
127.0.0.1:6379> lrange list 0 -1
1) "mmm"
2) "abc"
3) "two"
4) "one"
5) "zx"
127.0.0.1:6379>
```

**小结**

- list类型它实际上是一个链表，before Node after，left, right 都可以插入值

- 如果key不存在，创建新的链表

- 如果key存在，新增内容

- 如果移除了所有值，空链表，也代表不存在

- 在两插入或者改动值，效率最高！中简元素，效率会低一些

  **消息排队 、 消息队列（Lpush Roop），栈（Lpush Lpoo）**





--本文写作时借鉴了狂神这名UP主的视频讲解