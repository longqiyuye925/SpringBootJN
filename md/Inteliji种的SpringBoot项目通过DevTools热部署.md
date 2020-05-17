# Inteliji种的SpringBoot项目通过DevTools热部署



## 第一步：pom种添加下面的依赖

```xml
<!--添加热部署-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
    <scope>true</scope>
</dependency>
```

## 第二步，执行Ctrl + Alt +Shift +/弹出下面这个图片，选择Registry

![image-20200513211138807](C:\Users\wxc\AppData\Roaming\Typora\typora-user-images\image-20200513211138807.png)



## 第三步，红线圈的这一个key打钩

![image-20200513211226221](C:\Users\wxc\AppData\Roaming\Typora\typora-user-images\image-20200513211226221.png)

最后一步，下图出的红圈处打钩，为了自动编译

![image-20200513213012458](C:\Users\wxc\AppData\Roaming\Typora\typora-user-images\image-20200513213012458.png)