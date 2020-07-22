package com.bjsxt.springbootdemo.Service;

import com.bjsxt.springbootdemo.pojo.Users;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 07 2020/7/19
 */
@Service
public class UserService {
    public Boolean verifyUser(Users user){
        //这里不连接数据库，默认所有用户都对，方便调试
        return true;
    }
}
