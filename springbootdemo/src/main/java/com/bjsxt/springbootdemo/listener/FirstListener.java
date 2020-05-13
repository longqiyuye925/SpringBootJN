package com.bjsxt.springbootdemo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
