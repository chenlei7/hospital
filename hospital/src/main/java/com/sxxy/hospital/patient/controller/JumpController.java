package com.sxxy.hospital.patient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//跳转页面
@Controller
@RequestMapping("/jump")
public class JumpController {

    //挂号成功页面
    @RequestMapping("/success")
    public String success(){
        return "patient/success";
    }

    //挂号失败页面
    @RequestMapping("/false")
    public String flaes(){
        return "patient/false";
    }

}
