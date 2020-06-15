#                                       Redis数据类型：Set

注意点：set是无序不重复的集合

```bash
127.0.0.1:6379> sadd myset "hello"  #新建set
(integer) 1
127.0.0.1:6379> sadd myset "kuangsu"
(integer) 1
127.0.0.1:6379> sismember myset hello #判断set集合中有没有hello元素
(integer) 1
127.0.0.1:6379> sadd myset "hello" 
(integer) 0
127.0.0.1:6379> scard myset #显示set集合中的元素数量
(integer) 2
127.0.0.1:6379> srem myset kuangsu #移除set集合中的kuangsu元素
(integer) 1
127.0.0.1:6379> scard myset
(integer) 1
127.0.0.1:6379> get myset
(error) WRONGTYPE Operation against a key holding the wrong kind of value
127.0.0.1:6379> smembers myset #显示set集合中的所有元素
1) "hello"
127.0.0.1:6379> srandmember myset #随机取出set集合中的一个元素
"hello"
127.0.0.1:6379> sadd myset "qwe"
(integer) 1
127.0.0.1:6379> srandmember myset
"qwe"
127.0.0.1:6379> srandmember myset
"hello"
127.0.0.1:6379> dbsize
(integer) 9
127.0.0.1:6379> keys *
1) "user:1"
2) "user:2:name"
3) "k3"
4) "myset"
5) "k4"
6) "k2"
7) "v9"
8) "k1"
9) "user:2:age"
127.0.0.1:6379> keys myset
1) "myset"
127.0.0.1:6379> keys q
(empty list or set)
127.0.0.1:6379> smembers myset
1) "qwe"
2) "hello"
127.0.0.1:6379> spop myset #随机移除set集合中的一个元素
"hello"
127.0.0.1:6379> smembers myset
1) "qwe"
127.0.0.1:6379> smove myset qwe my123 
(integer) 0
127.0.0.1:6379> sadd my123 1
(integer) 1
127.0.0.1:6379> smove myset qwe my123
(integer) 0
127.0.0.1:6379> smove myset my123 qwe #将myset集合中的qwe元素移动到my123集合中
(integer) 1
127.0.0.1:6379> smembers myset
(empty list or set)
127.0.0.1:6379> smembers my123
1) "qwe"
2) "1"
127.0.0.1:6379> smember key1 q
(error) ERR unknown command 'smember'
127.0.0.1:6379> sadd key 1 q
(integer) 2
127.0.0.1:6379> sadd key2 w e
(integer) 2
127.0.0.1:6379> sdiff key key2 #取差集
1) "q"
2) "1"
127.0.0.1:6379> smembers key
1) "q"
2) "1"
127.0.0.1:6379> smembers key2
1) "w"
2) "e"
127.0.0.1:6379> sdiff key key2
1) "q"
2) "1"
127.0.0.1:6379> sdiff key2 key
1) "w"
2) "e"
127.0.0.1:6379> sinter key key2 #取交集
(empty list or set)
127.0.0.1:6379> sinter key key2
(empty list or set)
127.0.0.1:6379> smembers key
1) "q"
2) "1"
127.0.0.1:6379> sunion key key2 #取并集
1) "q"
2) "w"
3) "e"
4) "1"
127.0.0.1:6379>
```

**如何实现共同好友功能？**

可以通过sinter，比如A用户的所有好友的ID放到一个set集合，B用户所有好友的ID放到一个集合，然后取他们的交集 sinter AID BID

**如何实现可能认识功能？**

可以通过六度分割理论，首先使用身份证号作为外键去关联，A认识B，然后把B认识C，然后把去推荐给A试试，如果真的认识C，接着把C的好友D推荐给A

