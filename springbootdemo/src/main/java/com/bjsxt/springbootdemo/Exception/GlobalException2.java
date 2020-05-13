package com.bjsxt.springbootdemo.Exception;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @Description: 通过SimpleMappingExceptionResolver 处理全局异常
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/13
 */
@Configuration
public class GlobalException2 {
/*    public SimpleMappingExceptionResolver exceptionResolver() {
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        //注意此处的property的key必须是带包名的全称
        properties.put("java.lang.NullPointerException", "error");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }*/
}
