package com.sxxy.hospital.personnel.controller;

import com.sxxy.hospital.personnel.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userLogin")
public class UserLogin {
    //注入接口
    @Autowired
    DoctorService doctorService;

    //医生登录
    @RequestMapping("/doctor")
    public String doctorLogin(String doctorNum, String doctorPassword){
        if(doctorService.doctorLodin(doctorNum,doctorPassword)!=null) {
            return "personnel/doctor/doctorWork";
        }else {
            return "personnel/login";
        }
    }
}
