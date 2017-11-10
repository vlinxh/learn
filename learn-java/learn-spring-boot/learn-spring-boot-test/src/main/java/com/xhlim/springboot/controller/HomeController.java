package com.xhlim.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-08 14:33
 */
@Controller
public class HomeController {

    @Autowired
    private ServerProperties properties;

    @RequestMapping("/home/index")
    @ResponseBody
    public String home() {
        return "index_" + properties.getPort();
    }

}
