package com.sxxy.hospital.user.controller;

import com.sxxy.hospital.user.entity.EpidemicProtection;
import com.sxxy.hospital.user.mapper.EpidemicProtectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    EpidemicProtectionMapper epidemicProtectionMapper;

    //跳转到用户界面
    @RequestMapping("/index")
    public String goIndex(Model model){
        List<EpidemicProtection> epidemicProtections = epidemicProtectionMapper.findAll();
        model.addAttribute("a1",epidemicProtections.get(0));
        model.addAttribute("a2",epidemicProtections.get(1));
        model.addAttribute("a3",epidemicProtections.get(2));
        return "user/index";
    }



    //跳转世界疫情
    @RequestMapping("/index2")
    public String goWorldEpidemic(Model model){
        List<EpidemicProtection> epidemicProtections = epidemicProtectionMapper.findAll();
        model.addAttribute("a1",epidemicProtections.get(0));
        model.addAttribute("a2",epidemicProtections.get(1));
        model.addAttribute("a3",epidemicProtections.get(2));
        return "user/index2";
    }


}
