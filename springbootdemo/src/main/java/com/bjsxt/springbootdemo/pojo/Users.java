package com.bjsxt.springbootdemo.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @NotNull对基本类型的对象类型做非空校验
 * @NotBlank 对字符串类型做非空校验
 * @NotEmpty 对集合类型做非空校验
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/17
 */
public class Users {

    @NotNull(message = "{NotNull}")
    private Integer  userid;
    @NotBlank(message = "{NotNull}")
    private String username;
    @NotBlank(message = "{NotNull}")
    private String usersex;

    private String account;

    private String password;

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", usersex='" + usersex + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
