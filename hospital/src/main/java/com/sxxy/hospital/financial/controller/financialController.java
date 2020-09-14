package com.sxxy.hospital.financial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/financial")
public class financialController {

    @GetMapping("/login")
    public String login(){
        return "/financial/login";
    }

    @PostMapping("/login")
    public String login(String name ,String password){
        if(true){
            return "/financial/index";
        }else {
            return "/financial/login";
        }
    }

}
