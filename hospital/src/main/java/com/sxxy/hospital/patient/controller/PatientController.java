package com.sxxy.hospital.patient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("patient")
public class PatientController {

    //主页面
    @RequestMapping("index")
    public String index(){
        return "patient/index";
    }

    //查询全部病人信息
    @RequestMapping("patientsInfo")
    public String patientsInfo(){
        return "patient/patientsInfo";
    }
}
