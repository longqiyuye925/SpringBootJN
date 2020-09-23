package com.bjsxt.springbootdemo.Controller;

import com.alibaba.fastjson.JSON;
import com.bjsxt.springbootdemo.Service.TokenService;
import com.bjsxt.springbootdemo.Service.UserService;
import com.bjsxt.springbootdemo.model.LoginRequest;
import com.bjsxt.springbootdemo.model.LoginResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Description: 登录token验证
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 07 2020/7/19
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    TokenService tokenService;
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String userLogin(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        //验证token是否存在(这里暂时不用jwt)(引申一下还可以把用户的一些不重要的信息返回出去)
        String tokenStr = tokenService.verifyToken(loginRequest.getTokenStr());
        if (null != tokenStr && "1" != tokenStr) {
            loginResponse.setLogin(true);
            loginResponse.setTokenStr(tokenStr);
            return JSON.toJSONString(loginResponse);
        }
        //不存在去验证用户是否正常
        Boolean isExits = userService.verifyUser(loginRequest.getUsers());
        if (!isExits) {
            loginResponse.setMsg("当前用户不存在");
            return JSON.toJSONString(loginResponse);
        }
        //正常就生成新的token
        String token = tokenService.createTokenStr(loginRequest.getUsers().getAccount());
        // 存入redis，并返回给前台
        tokenService.save(token);
        loginResponse.setMsg("登录成功");
        loginResponse.setTokenStr(token);

        return JSON.toJSONString(loginResponse);
    }

    @RequestMapping("/dologin")
    public String dologin(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        System.out.println("username"+ username+"password" +password);
        try {

            subject.login(new UsernamePasswordToken(username, password));
            System.out.println("登陆成功");
            return "sucess";
        } catch (AuthenticationException e) {
            System.out.println("登陆失败");
            return "fail";
        }

    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("进入hello");
        return "hello";
    }

    @RequestMapping("/relogin")
    public String login() {
        return "please login!";
    }


}
