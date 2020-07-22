package com.bjsxt.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Description: 解决前端Access-Control-Allow-Origin跨域问题
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 07 2020/7/19
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowCredentials(true).maxAge(3600)
                .allowedHeaders("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS").allowedOrigins("*");
    }
}
