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

    //医生操作成功页面
    @RequestMapping("/doctorSuccess")
    public String doctorSuccess(){
        return "patient/doctor/doctorSuccess";
    }

    //跳到账单修改页面
    @RequestMapping("/billUpdate")
    public String billUpdate(){
        return "patient/bill/billUpdate";
    }

    //跳到查看挂号状态界面
    @RequestMapping("/registerState")
    public String registerState(){
        return "patient/registerState";
    }

}
