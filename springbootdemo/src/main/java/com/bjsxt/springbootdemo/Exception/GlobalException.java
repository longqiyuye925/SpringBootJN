package com.bjsxt.springbootdemo.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description:通过@ControllerAdvice和@ExceptionHandler注解处理全局异常所
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 05 2020/5/13
 */
@ControllerAdvice
public class GlobalException {
/*    @ExceptionHandler(value = {java.lang.NullPointerException.class})
    public ModelAndView nullExceptionToHandler(Exception e) {
        System.out.println(e.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("error", e);
        modelAndView.setViewName("error");
        return modelAndView;
    }*/
}
