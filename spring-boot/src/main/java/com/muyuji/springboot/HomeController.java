package com.muyuji.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-08 14:33
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "home";
    }

}
