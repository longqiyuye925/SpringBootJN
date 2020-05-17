# SpringBoot集成使用Servlet、Filter、Listener

**背景：有了SpringMVC的controller，还要再去使用Servlet，有了servlet3@WebServlet的注解还要再去使用ServletRegistrationBean注入，这些原因都是为了使用别的开源的jar。例如：hystrix-dashboard，需要注入HystrixMetricsStreamServlet，这个servlet是hystrix的组件。**

## 一：集成Servlet

### 通过注解的方式集成Servlet

#### 第一步写Servlet

```java
/**
 * @Description: 采用注解的方式，集成Servlet
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/7
 */
//@WebServlet(name = "FirstServlet",urlPatterns ={"*.do","*.jsp"})
@WebServlet(name = "FirstServlet",urlPatterns = "/first")
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("come in FirstServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
```

#### 第二步：启动类配置注解

```Java
@SpringBootApplication
@ServletComponentScan
public class SpringbootdemoApplication {

   public static void main(String[] args) {
      SpringApplication.run(SpringbootdemoApplication.class, args);
   }

}
```

### 通过ServletRegistrationBean注入

#### 第一步：写一个servlet

```Java
/**
 * @Description: 采用配置的方式，注册servlet
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/7
 */
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("come in  SecondServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
```

#### 第二步：写一个servlet配置类

```Java
/**
 * @Description: servlet的注册类
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/7
 */
@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean getServletRegistrationBean() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }
}
```

## 二：集成Filter（与集成Servlet很类似）

### 通过注解配置Filter

#### 第一步：写一个filter

```Java
/**
 * @Description: 采用注解的方式注册filter
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/7
 */
//@WebFilter(filterName = "FirstFilter",urlPatterns = {"*.do","*.jsp"})
@WebFilter(filterName = "FirstFilter", urlPatterns = "/first")
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入FirstFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("离开FirstFilter");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
```

#### 第二步：启动类添加@ServletComponentScan注解（这个可以对servlet和Filter和Lister生效）

### 通过FilterRegistrationBean注入

#### 第一步：写一个Filter

```java
/**
 * @Description: 采用配置类的方式，注册Filter
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/7
 */
public class SecondFliter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入SecondFliter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("离开SecondFliter");
    }

    @Override
    public void destroy() {

    }
}
```

#### 第二步：配置一个Filter配置类

```Java
/**
 * @Description: Filter配置类
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/7
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean getFilterRegistrationBean() {
        FilterRegistrationBean bean = new FilterRegistrationBean(new SecondFliter());
        bean.addUrlPatterns("/second");
        return bean;
    }
}
```

## 三：集成listener

### 通过注解方式

#### 第一步：写一个Listener

```Java
/**
 * @Description: servlet的listener有八种，这里采用上下文监听
 * @author: zf
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/7
 */
@WebListener
public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("进入FirstListener");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
```

#### 第二步：启动类上加上@ServletComponentScan注解