package com.sxxy.hospital.personnel.controller;

import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.entity.Other;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import com.sxxy.hospital.personnel.mapper.OtherMapper;
import com.sxxy.hospital.personnel.service.DoctorService;
import com.sxxy.hospital.personnel.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/other")
public class OtherController {
    @Autowired
    OtherService otherService;
    @Autowired
    OtherMapper otherMapper;

    //增加员工
    @RequestMapping("/addOther")
    public String addOther(String otherNum, String otherName, int otherAge, String otherGender, String otherPosition, String otherWorkspace, String otherWorkDate ) {
        Other other = new Other(otherNum,otherName,otherAge,otherGender,otherPosition,otherWorkspace,otherWorkDate,"123",10000,"可出工");
        if (other != null) {
            otherService.addOther(other);
            return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //编辑员工信息
    @RequestMapping("/updateOther")
    public String updateOther(String otherPosition, String otherWorkspace, String otherWorkDate, String otherPassword,double otherMoney, String otherNum) {
        int updateOther = otherMapper.updateNurse(otherPosition,otherWorkspace,otherWorkDate,otherPassword,otherMoney,otherNum);
        if (updateOther > 0) {
            return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //查看所有员工
    @RequestMapping("/others")
    public String allOther(Model model) {
        List<Other> others = new ArrayList<>();
        try {
            others = otherMapper.findAll();
        }catch (Exception e){
            return "personnel/error";
        }
        model.addAttribute("others", others);
        return "personnel/other/others";
    }

    //查看所有员工详细信息
    @RequestMapping("/otherInfo")
    public String otherInfo(Model model) {
        List<Other> others = new ArrayList<>();
        others = otherMapper.findAll();
        model.addAttribute("others", others);
        return "personnel/other/aboutOther";
    }

    //删除员工信息
    @RequestMapping("/deleteOther")
    public String deleteOther(String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                otherMapper.deleteOtherByOtherNum(Collections.singletonList(strs[i]));
            } catch (Exception e) {
                return "personnel/error";
            }
        }
        return "personnel/other/others";
    }

    //修改员工现状
    @RequestMapping("/editOtherNowState")
    public String editOtherNowState(String otherState,String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                otherService.editOtherNowState(otherState,Collections.singletonList(strs[i]));
            } catch (Exception e) {
                return "personnel/error";
            }
        }
        return "personnel/other/others";
    }

}
