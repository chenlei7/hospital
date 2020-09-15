package com.sxxy.hospital.financial.controller;

import com.sxxy.hospital.financial.service.FinancialService;
import com.sxxy.hospital.financial.service.impl.FinancialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //get方式访问login
    @GetMapping("/login")
    public String login(){
        return "/financial/login";
    }
    //post方式进行登录
    @PostMapping("/login")
    public String login(String name ,String password){
        if(true){
            return "/financial/index";
        }else {
            return "redirect:financial/login";
        }
    }
    //跳转到登录主界面
    @RequestMapping("/index")
    public String index(){
        return "/financial/index";
    }
    //跳转到财务表
    @RequestMapping("/financial")
    public String financial(Model model){
        List<Map> list = service.findAll();
        model.addAttribute("lists", list);
        return "financial/financial";
    }

}
