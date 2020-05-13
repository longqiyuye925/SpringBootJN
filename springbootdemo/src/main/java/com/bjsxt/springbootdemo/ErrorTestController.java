package com.bjsxt.springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: 通过@ExceptionHandler注解处理异常
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/12
 */
@Controller
@RequestMapping("/errortest")
public class ErrorTestController {
    @RequestMapping("/showInfo")
    public String showInfo() {
        String str = null;
        str.length();
        return "OK";
    }

/*    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullExceptionToHandler(Exception e) {
        System.out.println(e.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e);
        modelAndView.setViewName("error");
        return modelAndView;
    }*/
}
