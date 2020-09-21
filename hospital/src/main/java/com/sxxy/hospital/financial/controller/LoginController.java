package com.sxxy.hospital.financial.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {
    //get方式访问login
    @GetMapping("login")
    public String login(){
        return "financial/login";
    }
    //post方式进行登录

    @PostMapping("login")
    public String login(String name , String password, String role, HttpSession session){
        session.setAttribute("role",role);
        System.out.println(role+"--------------------------");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        try {
            subject.login(token);
        }catch (AuthenticationException ae){
            return "financial/login";
        }
        if ("人事部".equals(role)){
            return "redirect:/personnel/index";
        }else if ("财务部".equals(role)){
            return "redirect:/financial/index";
        }else if ("医生".equals(role)||"护士".equals(role)){
            return "redirect:/patient/index";
        }else if ("后勤部".equals(role)){
            return "redirect:/room/rooms";
        }else {
            return "financial/login";
        }
    }
}
