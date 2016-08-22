package com.xpay.trade.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sxfans on 16/8/14.
 */
@Controller
public class TestControl {

    /**
     * 测试
     * @return
     */
    @RequestMapping("/test")
    public ModelAndView test(){
        System.out.println("testtest");
        return null;
    }
}
