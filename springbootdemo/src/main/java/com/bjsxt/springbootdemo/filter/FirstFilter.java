package com.bjsxt.springbootdemo.filter;

import org.omg.CosNaming.NameComponent;

import javax.naming.Name;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

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
