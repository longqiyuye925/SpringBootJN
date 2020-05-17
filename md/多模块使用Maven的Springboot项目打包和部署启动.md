# 多模块使用Maven的Springboot项目打Jar包和部署启动

## 打jar包：

找出项目里所有的pom文件，看最外层的pom，是否是父pom（一般都是它）

![image-20200508211314982](C:\Users\wxc\AppData\Roaming\Typora\typora-user-images\image-20200508211314982.png)

然后执行mvn clean install，成功后依次把其他的pom文件所在model也执行mvn clean install

都成功后，在启动类里跑一下main函数看看能否启动成功。

## 进行war包或者jar包部署

先把war包或者jar制作出来：

![image-20200508211818829](C:\Users\wxc\AppData\Roaming\Typora\typora-user-images\image-20200508211818829.png)

先执行clean，然后执行package，出现下图所示后

![image-20200508215411912](C:\Users\wxc\AppData\Roaming\Typora\typora-user-images\image-20200508215411912.png)

执行 java -jar springbootdemo-0.0.1-SNAPSHOT.jar