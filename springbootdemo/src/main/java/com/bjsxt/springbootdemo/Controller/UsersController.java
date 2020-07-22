package com.bjsxt.springbootdemo.Controller;

import com.bjsxt.springbootdemo.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/17
 */
@Controller
@RequestMapping("/user")
public class UsersController {
    @RequestMapping("/adduser")
    /**
     * 服务端数据校验
     * part1:对实体对象进行校验
     */
    public String addUser(@Validated @ModelAttribute("aa") Users users, BindingResult bindingResult) {
        List<ObjectError> errorList = bindingResult.getAllErrors();
        if (bindingResult.hasErrors()) {
            for (int i = 0; i < errorList.size(); i++) {
                FieldError fieldError = (FieldError) errorList.get(i);
                System.out.println("名称：" + fieldError.getField() + "信息：" + fieldError.getDefaultMessage());

            }
            System.out.println(users);
            return "addUsers";
        }
        return "OK";
    }
}
