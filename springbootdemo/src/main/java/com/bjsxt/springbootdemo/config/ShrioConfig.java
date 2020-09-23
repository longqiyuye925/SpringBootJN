package com.bjsxt.springbootdemo.config;

import com.bjsxt.springbootdemo.common.MyRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @author: zf
 * @Param:
 * @Return:
 * @Date: 2020 09 2020/9/23
 */
@Configuration
public class ShrioConfig {
    @Bean
    MyRealm myRealm() {
        return new MyRealm();
    }

    @Bean
    DefaultWebSecurityManager  securityManager() {
        DefaultWebSecurityManager  defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(myRealm());
        return defaultSecurityManager;
    }

    @Bean
    ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition defaultShiroFilterChainDefinition = new DefaultShiroFilterChainDefinition();
        //谁都可以访问
        defaultShiroFilterChainDefinition.addPathDefinition("/login/dologin", "anon");
        //认证后（登录）才可以访问
        defaultShiroFilterChainDefinition.addPathDefinition("/**", "authc");
        return defaultShiroFilterChainDefinition;
    }
}
