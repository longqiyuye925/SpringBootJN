package com.bjsxt.springbootdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Description: 自定义HandlerExceptionResolver处理异常
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/13
 */
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
