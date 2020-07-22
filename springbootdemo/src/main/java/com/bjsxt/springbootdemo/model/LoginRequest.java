package com.bjsxt.springbootdemo.model;

import com.bjsxt.springbootdemo.pojo.Users;

/**
 * @Description:
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 07 2020/7/19
 */
public class LoginRequest {
    private Users users;
    private String tokenStr;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }
}
