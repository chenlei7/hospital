package com.sxxy.hospital.personnel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personnel")
public class PersonnelController {
    //跳到登录界面
    @RequestMapping("/login")
    public String goLogin(){
        return "personnel/login";
    }

    //跳到首页
    @RequestMapping("/index")
    public String goIndex(){
        return "personnel/index";
    }

    //增加医生
    @RequestMapping("/addDoctor")
    public String goAddDoctor(){
        return "personnel/doctor/addDoctor";
    }

    //查看医生详细信息
    @RequestMapping("/aboutDoctor")
    public String goAboutDoctor(){
        return "personnel/doctor/aboutDoctor";
    }

    //修改医生信息
    @RequestMapping("/editDoctor")
    public String goEditDoctor(){
        return "personnel/doctor/editDoctor";
    }

}
