package com.sxxy.hospital.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class userController {

    //跳转到用户界面
    @RequestMapping("/index")
    public String goIndex(){
        return "user/index";
    }

    //挂号界面
    @RequestMapping("/registered")
    public String goRegistered(){
        return "user/registered";
    }
}
