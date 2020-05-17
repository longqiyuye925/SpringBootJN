# 					SpringBoot异常处理

## 先附上异常跳转的页面

```HTML
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>出错了</title>
</head>
<body>
<form>
    <input type="text" /><font color="#8b0000"><span th:text="${error}"></span> </font>
</form>
</body>
</html>
```

## 第一种： 通过@ExceptionHandler处理某一个controller里的异常

```java
@Controller
@RequestMapping("/errortest")
public class ErrorTestController {
    @RequestMapping("/showInfo")
    public String showInfo() {
        String str = null;
        str.length();
        return "OK";
    }

    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullExceptionToHandler(Exception e) {
        System.out.println(e.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
```

## 第二种： 通过@ControllerAdvice和@ExceptionHandler处理全局异常

```java
@ControllerAdvice
public class GlobalException {
   @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullExceptionToHandler(Exception e) {
        System.out.println(e.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
```

## 第三种： 通过@Configuration和SimpleMappingExceptionResolver处理全局异常

```java
@Configuration
public class GlobalException2 {
   public SimpleMappingExceptionResolver exceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        //注意此处的property的key必须是带包名的全称
        properties.put("java.lang.NullPointerException", "error");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }
}
```

## 第四种： 通过@Configuration和HandlerExceptionResolver处理全局异常

```java
@Configuration
public class ExceptionConfig implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof NullPointerException) {
            modelAndView.setViewName("error");
        }
        modelAndView.addObject("error", "你怎么不来");
        return modelAndView;
    }
}
```

