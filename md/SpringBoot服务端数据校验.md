# 				SpringBoot服务端数据校验

## 第一步：首先对需要校验的pojo类，添加注解

```java
/**
 * @Description:
 * @NotNull对基本类型的对象类型做非空校验
 * @NotBlank 对字符串类型做非空校验
 * @NotEmpty 对集合类型做非空校验
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/17
 */
public class Users {
    @NotNull(message = "{NotNull}")
    private Integer  userid;
    @NotBlank(message = "{NotNull}")
    private String username;
    @NotBlank(message = "{NotNull}")
    private String usersex;

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", usersex='" + usersex + '\'' +
                '}';
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }
}
```

### 校验的注解种类如下所示

- `@Null`   被注释的元素必须为 null
- `@NotNull`    被注释的元素必须不为 null
- `@AssertTrue`     被注释的元素必须为 true
- `@AssertFalse`    被注释的元素必须为 false
- `@Min(value)`    被注释的元素必须是一个数字，其值必须大于等于指定的最小值
- `@Max(value)`    被注释的元素必须是一个数字，其值必须小于等于指定的最大值
- `@DecimalMin(value)` 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
- `@DecimalMax(value)`  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
- `@Size(max=, min=)`  被注释的元素的大小必须在指定的范围内
- `@Digits (integer, fraction)`    被注释的元素必须是一个数字，其值必须在可接受的范围内
- `@Past`  被注释的元素必须是一个过去的日期
- `@Future`     被注释的元素必须是一个将来的日期
- `@Pattern(regex=,flag=)` 被注释的元素必须符合指定的正则表达式

**Hibernate Validator提供的校验注解**：

- `@NotBlank(message =)`  验证字符串非null，且长度必须大于0
- `@Email`  被注释的元素必须是电子邮箱地址
- `@Length(min=,max=)` 被注释的字符串的大小必须在指定的范围内
- `@NotEmpty`  被注释的字符串的必须非空
- `@Range(min=,max=,message=)`  被注释的元素必须在合适的范围内

### message = "{NotNull}"属性是用来自定义错误返回信息

如果不显示使用，则后返回默认的错误信息。这里的{}是从配置文件中取出国际化信息，NotNull是key

### 默认的国际化文件放在resources根目录下，名称默认是ValidationMessages.properties

如果想自定义配置文件的名称和路径，需要定义配置类

```java
/**
 * @Description: 自定义校验文件的路径和名称，默认是ValidationMessages.properties文件，放在resources目录下
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/17
 */
@Configuration
public class ValidationConfig {
    @Bean
    public javax.validation.Validator getValidator() {
        Validator validator = Validation.byDefaultProvider().
                configure().
                messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("i18n/validation/cutomerValidationMessage"))).
                buildValidatorFactory().getValidator();
        return validator;
    }
}
```

i18n/validation/cutomerValidationMessage 对应的就是resources目录下的i18n/validation里的cutomerValidationMessage 配置文件

## 第二步，参与校验的controller

```java
@Controller
@RequestMapping("/user")
public class UsersController {
    @RequestMapping("/adduser")
    /**
     * 服务端数据校验
     * part1:对实体对象进行校验
     */
    public String addUser(@Validated @ModelAttribute("aa") Users users, BindingResult bindingResult) {
        List<ObjectError> errorList = bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            for (int i = 0; i < errorList.size(); i++) {
                FieldError fieldError = (FieldError) errorList.get(i);
                System.out.println("名称：" + fieldError.getField() + "信息：" + fieldError.getDefaultMessage());

            }
            System.out.println(users);
            return "addUsers";
        }
        return "OK";
    }
}
```

### 这里的@Validated标签是对Users使用校验的意思，@ModelAttribute是指对于返回给model的users对象的别名，这里起为aa

### BindingResult bindingResult 是必须存在的，校验后的错误信息存放在bindingResult 对象里面

## 第三步，写访问页面



## 由于此时使用的是thymeleaf模板，无法直接访问到templates的html,所以先写一个跳转类

```java
/**
 * @Description: 解决使用thymeleaf时，无法直接访问页面的方法
 * @author:
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/17
 */
@Controller
public class pageController {
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page,@ModelAttribute("aa") Users users) {
        System.out.println(page);
        return page;
    }
}
```

这里的/{page}指的是把/后面的字符串作为参数，传给下面带@PathVariable标签的page。

由于待会我们写的页面会使用到aa对象，如果初始化页面时没有aa会报错，所以此时页面跳转的时候加上@ModelAttribute("aa") Users users

### 放上用于测试校验功能的页面

```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form th:action="@{/user/adduser}" method="post">
    <input type="text" name="username"/><font color="#b22222"><span th:errors="${aa.username}"></span></font>
    <input type="text" name="usersex"/><font color="#b22222"><span th:errors="${aa.usersex}"></span></font>
    <input type="submit" name="OK">
</form>
</body>
</html>
```

注意**th:errors**标签，后面使用的el表达式，放上aa对象的属性，就会把对应属性的错误信息填充到这里

### 初始化页面效果图

![image-20200517153927188](C:\Users\wxc\AppData\Roaming\Typora\typora-user-images\image-20200517153927188.png)

### 提交后的校验效果图

![image-20200517153952218](C:\Users\wxc\AppData\Roaming\Typora\typora-user-images\image-20200517153952218.png)