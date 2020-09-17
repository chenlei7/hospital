package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.patient.entity.Illness;
import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.IllnessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//跳转页面
@Controller
@RequestMapping("/illness")
public class IllnessController {

    @Autowired
    IllnessMapper illnessMapper;


    //查询出全部的病情信息
    @RequestMapping("/illnessAll")
    public String illnessAll(Model model){
        List<Illness> illnesses = new ArrayList<>();
        illnesses = illnessMapper.findAll();
        model.addAttribute("illnesses",illnesses);
        return "patient/illness/illnessAll";
    }

    //修改病情信息
    @PostMapping("/illnessUpdate")
    public  String illnessUpdate(int illnessId,String illnessTime,String illness_condition,String illnessSeverity,String illnessAlive) {
        int a = illnessMapper.illnessUpdate(illnessTime,illness_condition,illnessSeverity,illnessAlive,illnessId);
        if (a > 0) {
            return "redirect:/illness/illnessAll";
        } else {
            return "patient/error";
        }

    }

}
