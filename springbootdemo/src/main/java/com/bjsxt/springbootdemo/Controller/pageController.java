package com.bjsxt.springbootdemo.Controller;

import com.bjsxt.springbootdemo.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 解决使用thymeleaf时，无法直接访问页面的方法
 * @author:
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/17
 */
@Controller
public class pageController {
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page,@ModelAttribute("aa") Users users) {
        System.out.println(page);
        return page;
    }
}
