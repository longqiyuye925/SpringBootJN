# 特殊数据类型 ：**Geospatial** **地理位置**

```bash
127.0.0.1:6379> geoadd china:city 116.40 39.90 beijing # 加入一个地理位置
(integer) 1
127.0.0.1:6379> geoadd china:city 121.47 31.23 shanghai
(integer) 1
127.0.0.1:6379> geoadd china:city 106.50 29.53 chongqing
(integer) 1
127.0.0.1:6379> geoadd china:city 120.16 30.24 hangzhou
(integer) 1
127.0.0.1:6379> geopos china:city beijing #显示一个地理位置
1) 1) "116.39999896287918"
   2) "39.900000091670925"
127.0.0.1:6379> geopos china:city beijing chongqing
1) 1) "116.39999896287918"
   2) "39.900000091670925"
2) 1) "106.49999767541885"
   2) "29.529999579006592"
127.0.0.1:6379> geodist china:city beijing shanghai km #计算两个地理位置之间的距离  （m 米/km 千米/im 英里/ft 尺）
"1067.3788"
127.0.0.1:6379> geodist china:city beijing chongqing km
"1464.0708"
127.0.0.1:6379> georadius china:city 110 30 1000 km
# 计算指定经纬度和半径范围内的其它位置名称
1) "chongqing"
2) "hangzhou"
127.0.0.1:6379> georadius china:city 110 30 500 km
1) "chongqing"
127.0.0.1:6379> georadius china:city 110 30 500 km withcoord # 计算指定经纬度和半径范围内的其它位置信息
1) 1) "chongqing"
   2) 1) "106.49999767541885"
      2) "29.529999579006592"
127.0.0.1:6379> georadius china:city 110 30 1000 km withdist # 计算指定经纬度和半径范围内的其它位置距离
1) 1) "chongqing"
   2) "341.9374"
2) 1) "hangzhou"
   2) "977.5143"
127.0.0.1:6379> georadius china:city 110 30 1000 km withdist count 1 # 计算指定经纬度和半径范围内的其它位置距离，同时规定显示多少个（可用于微信摇一摇搜索指定人数）
1) 1) "chongqing"
   2) "341.9374"
127.0.0.1:6379> geohash china:city beijing chongqing
#拔两地之间的距离转换为hash值
1) "wx4fbxxfke0" 
2) "wm5xzrybty0"
127.0.0.1:6379> zrange china:city 0 -1 # geo底层实现是zset，所以可以通过它的命令去操作geo
1) "chongqing"
2) "hangzhou"
3) "shanghai"
4) "beijing"
127.0.0.1:6379> zrem china:city beijing
(integer) 1
127.0.0.1:6379> zrange china:city 0 -1
1) "chongqing"
2) "hangzhou"
3) "shanghai"
127.0.0.1:6379>
```

**朋友的定位，附近的人，打车距离计算，微信摇一摇，这些功能都可以通过Geospatial数据类型来实现**

Redis的GEO在3.2版本就推出了，可以计算地理位置信息，两地之间的距离，方圆几里的人。



http://www.jsons.cn/lngcodeinfo/0706D99C19A781A3/ 可以查询经纬度