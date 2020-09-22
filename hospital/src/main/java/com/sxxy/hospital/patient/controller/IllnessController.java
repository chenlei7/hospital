package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.patient.entity.Illness;
import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.IllnessMapper;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

//跳转页面
@Controller
@RequestMapping("/illness")
public class IllnessController {

    @Autowired
    IllnessMapper illnessMapper;


    //查询出全部的病情信息
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @RequestMapping("/illnessAll")
    public String illnessAll(Model model){
        List<Illness> illnesses = new ArrayList<>();
        illnesses = illnessMapper.findAll();
        model.addAttribute("illnesses",illnesses);
        return "patient/illness/illnessAll";
    }

    //修改病情信息
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @PostMapping("/illnessUpdate")
    public  String illnessUpdate(int illnessId1,String illnessTime1,String illness_condition1,String illnessSeverity1,String illnessAlive1) {
        int a = illnessMapper.illnessUpdate(illnessTime1,illness_condition1,illnessSeverity1,illnessAlive1,illnessId1);
        if (a > 0) {
            return "redirect:/illness/illnessAll";
        } else {
            return "patient/error";
        }

    }

    //增加实时病情
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @PostMapping("/illnessAdd")
    public String illnessAdd(Illness illness){
        try {
            illnessMapper.save(illness);
        }catch (Exception e){
            return "patient/error";
        }
        return "redirect:/illness/illnessAll";
    }

    //查询全部病情
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @ResponseBody
    @GetMapping("/findAllIllness")
    public Set<String> findAllIllness(){
        List<Illness> list = illnessMapper.findAll();
        Set<String> set = new HashSet<>();
        for (Illness in:list){
           String num =  in.getIllnessNum();
            set.add(num);
        }
        return set;
    }

}
