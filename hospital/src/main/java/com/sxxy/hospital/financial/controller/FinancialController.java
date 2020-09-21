package com.sxxy.hospital.financial.controller;

import com.sxxy.hospital.financial.service.DAService;
import com.sxxy.hospital.financial.service.FinancialService;
import com.sxxy.hospital.financial.service.impl.FinancialServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
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
    @Autowired
    FinancialService financialService;
    //跳转到登录主界面
    @RequiresRoles(value={"admin","financialer"},logical = Logical.OR)
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

        return "/financial/index";
    }
    //跳转到财务表
    @RequiresRoles(value={"admin","financialer"},logical = Logical.OR)
    @RequestMapping("/financial")
    public String financial(Model model){
        List<Map> lists = service.findAll();
        model.addAttribute("lists", lists);
        return "/financial/financial";
    }

    @GetMapping("/add")
    public String add(){
        return "/financial/add";
    }


    @PostMapping("/add")
    @ResponseBody
    public String addFinancial(String statementNum,String statementName,String statementDeptName,String statementType,String statementEvent,String statementTime,int statementState,double statementMoney){
        int m = financialService.add(statementNum, statementName, statementDeptName, statementType, statementEvent, statementTime, statementState, statementMoney);
        return "添加成功,<a href='/financial/add'>点击返回</a>";
    }
}
