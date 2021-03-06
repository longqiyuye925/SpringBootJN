package com.bjsxt.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @author: wsc
 * @Param:
 * @Return:
 * @Date: 2020 04 2020/4/28
 */
@RestController
@RequestMapping("/logback")
public class HelloController {
    private final static Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;
    @RequestMapping("/showInfo")
    public String showInfo() {
        session.getId();
        logger.debug("记录日志");
        return "Hello Logback";
    }
}
