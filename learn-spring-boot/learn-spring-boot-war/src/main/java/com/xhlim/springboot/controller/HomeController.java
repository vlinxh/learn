package com.xhlim.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xhlim@outlook.com
 * @create 2017-10-17
 */
@Controller
public class HomeController {


    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "你好";
    }

}
