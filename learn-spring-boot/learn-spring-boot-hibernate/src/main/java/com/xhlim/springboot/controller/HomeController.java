package com.xhlim.springboot.controller;


import com.xhlim.springboot.entity.User;
import com.xhlim.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author xhlim@outlook.com
 * @create 2017-09-08 14:33
 */
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    @ResponseBody
    public String home() {
        return "你好";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser() {
        User user = new User();
        user.setName("张三");
        user.setLastLogin(new Date());
        user.setPassword("1234567");
        User saveUser = userService.saveUser(user);
        return  saveUser.getId();
    }

    @RequestMapping("/findUser")
    @ResponseBody
    public User findUser(String id) {
        if (id == null || id.length() == 0) {
            throw new RuntimeException("id 不能为空");
        }
        User user = userService.findUser(id);
        return  user;
    }


}
