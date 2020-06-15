# 					Redis学习准备篇

## 重新复习Redis

Redis汉语网站

https://www.redis.net.cn/order/

为了方便，直接使用Windows版的Redis

下载地址：

https://github.com/microsoftarchive/redis/releases/tag/win-3.2.100

下载zip版

![image-20200520213241802](C:\Users\wxc\AppData\Roaming\Typora\typora-user-images\image-20200520213241802.png)分别启动服务端和客户端

开始练习

## Redis-key

sizedb  当前库里的数据条数

select index 进入哪一个库

keys * 显示所有key-value

flushdb 清空当前库

set key value 设置一个键值对

get key 取到值

exists name 判断是否存在key为name的键值对

move name 1 在当前库移除key为name的键值对（1代表当前库）

expire name 10  key为name的键值对失效时间设置为10秒（可用于session和token生失效，单点登录，验证码功能）

ttl name  判断剩余失效时间



**下一篇是五大数据类**型

