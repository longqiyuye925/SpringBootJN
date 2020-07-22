package com.bjsxt.springbootdemo.model;

import com.bjsxt.springbootdemo.pojo.Users;

/**
 * @Description:
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 07 2020/7/19
 */
public class LoginResponse {
    private String tokenStr;
    private String msg;
    private Boolean isLogin;

    public Boolean getLogin() {
        return isLogin;
    }

    public void setLogin(Boolean login) {
        isLogin = login;
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
