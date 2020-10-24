package com.bjsxt.springbootdemo.Service;

import com.bjsxt.springbootdemo.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 07 2020/7/19
 */
@Service
public class UserService {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;
    public Boolean verifyUser(Users user){
        //这里不连接数据库，默认所有用户都对，方便调试
        return true;
    }
}
