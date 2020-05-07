package com.bjsxt.springbootdemo.filter;

import javax.servlet.*;
import java.io.IOException;

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
