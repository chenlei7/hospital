package com.sxxy.hospital.personnel.controller;

import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.entity.Nurse;
import com.sxxy.hospital.personnel.entity.Other;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import com.sxxy.hospital.personnel.mapper.OtherMapper;
import com.sxxy.hospital.personnel.service.DoctorService;
import com.sxxy.hospital.personnel.service.OtherService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String addOther(String otherNum, String otherName, int otherAge, String otherGender, String otherPosition, String otherWorkspace, String otherWorkDate ) {
        Other other = new Other(otherNum,otherName,otherAge,otherGender,otherPosition,otherWorkspace,otherWorkDate,"123",1500,"可出工");
        if (other != null) {
            otherService.addOther(other);
            return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //编辑员工信息
    @RequestMapping("/updateOther")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
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
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
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
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String otherInfo(Model model) {
        List<Other> others = new ArrayList<>();
        others = otherMapper.findAll();
        model.addAttribute("others", others);
        return "personnel/other/aboutOther";
    }

    //删除员工信息
    @RequestMapping("/deleteOther")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
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
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
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

    //查询编号是否存在
    @RequestMapping("/queryNum")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    @ResponseBody
    public Other queryNum(String otherNumber,Model model) {
        Other otherNum = otherMapper.findByOtherNum(otherNumber);
        if (otherNum==null){
            Other o = new Other();
            o.setOtherNum("编号不存在");
            return o;
        }
        return otherNum;
    }
}
