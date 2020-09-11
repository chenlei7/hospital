package com.sxxy.hospital.personnel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept")
public class AdminController {
    //跳到登录界面
    @RequestMapping("/login")
    public String goLogin(){
        return "personnel/login";
    }
}
