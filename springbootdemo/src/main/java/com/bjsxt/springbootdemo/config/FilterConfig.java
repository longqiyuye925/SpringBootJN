package com.bjsxt.springbootdemo.config;

import com.bjsxt.springbootdemo.filter.SecondFliter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
