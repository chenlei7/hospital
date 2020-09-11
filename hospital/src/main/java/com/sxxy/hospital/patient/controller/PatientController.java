package com.sxxy.hospital.patient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("patient")
public class PatientController {

    @RequestMapping("index")
    public String index(){
        return "patient/index";
    }
}
