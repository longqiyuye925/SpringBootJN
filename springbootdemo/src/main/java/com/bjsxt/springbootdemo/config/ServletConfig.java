package com.bjsxt.springbootdemo.config;

import com.bjsxt.springbootdemo.servlet.SecondServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
