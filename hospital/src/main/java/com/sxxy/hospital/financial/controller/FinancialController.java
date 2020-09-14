package com.sxxy.hospital.financial.controller;

import com.sxxy.hospital.financial.service.FinancialService;
import com.sxxy.hospital.financial.service.impl.FinancialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/financial")
public class FinancialController {

    @Autowired
    FinancialService service;

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

    @RequestMapping("/all")
    @ResponseBody
    public List<Map> all(){
        return service.findAll();
    }
}
