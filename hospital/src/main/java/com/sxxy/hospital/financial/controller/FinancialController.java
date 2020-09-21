package com.sxxy.hospital.financial.controller;

import com.sxxy.hospital.financial.service.DAService;
import com.sxxy.hospital.financial.service.FinancialService;
import com.sxxy.hospital.financial.service.impl.FinancialServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/financial")
public class FinancialController {

    @Autowired
    FinancialService service;
    @Autowired
    DAService daService;

    //get方式访问login
    @GetMapping("/login")
    public String login(){
        return "financial/login";
    }
    //post方式进行登录

    @PostMapping("/login")
    public String login(String name , String password, String role, HttpSession session){
        session.setAttribute("role",role);
        System.out.println(role+"--------------------------");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
        try {
            subject.login(token);
        }catch (AuthenticationException ae){
            return "/financial/login";
        }
        if ("人事部".equals(role)){
            return "redirect:/personnel/index";
        }else if ("财务部".equals(role)){
            return "redirect:/financial/index";
        }else if ("医生".equals(role)||"护士".equals(role)){
            return "redirect:/patient/index";
        }else if ("后勤部".equals(role)){
            return "";
        }else {
            return "/financial/login";
        }
    }
    //跳转到登录主界面
    @RequestMapping("/index")
    public String index(Model model){
        List<Map> lists = daService.findMoneyByDate();
        //获取昨天的信息
        Map map = lists.get(0);
        //各个字段的list
        List<Double> pay = new ArrayList<>();
        List<Double> revenue = new ArrayList<>();
        List<Double> total = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        //用于格式化数据库传过来的时间
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");

        //循环添加到各个list中
        for (Map m:lists){
            pay.add((Double) m.get("DA_pay"));
            revenue.add((Double) m.get("DA_revenue"));
            total.add((Double) m.get("DA_total"));
            dates.add(format.format(m.get("DA_date")));
        }

        //将数据倒序
        Collections.reverse(pay);
        Collections.reverse(revenue);
        Collections.reverse(dates);
        Collections.reverse(total);

        //获取全部金额
        double totalMoney = daService.totalMoney();

        //将需要的数据装入model
        model.addAttribute("map",map);
        model.addAttribute("totalMoney",totalMoney);
        model.addAttribute("pays",pay);
        model.addAttribute("revenues",revenue);
        model.addAttribute("totals",total);
        model.addAttribute("dates",dates);

        return "financial/index";
    }
    //跳转到财务表
    @RequestMapping("/financial")
    public String financial(Model model){
        List<Map> lists = service.findAll();
        model.addAttribute("lists", lists);
        return "financial/financial";
    }

}
