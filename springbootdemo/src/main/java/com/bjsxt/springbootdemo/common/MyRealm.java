package com.bjsxt.springbootdemo.common;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Description:
 * @author: zf
 * @Param:
 * @Return:
 * @Date: 2020 09 2020/9/23
 */
public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        System.out.println("getPrincipal" + username);
        if (!"wushichao".equals(username) ) {
            System.out.println("账户不存在");
            throw new UnknownAccountException("账户不存在");
        }
        return new SimpleAuthenticationInfo(username, "123", getName());

    }
}
