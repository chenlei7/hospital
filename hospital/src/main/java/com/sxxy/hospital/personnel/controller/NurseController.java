package com.sxxy.hospital.personnel.controller;


import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.entity.Nurse;
import com.sxxy.hospital.personnel.mapper.NurseMapper;
import com.sxxy.hospital.personnel.service.NurseService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/nurse")
public class NurseController {
    @Autowired
    NurseService nurseService;
    @Autowired
    NurseMapper nurseMapper;

    //增加护士
    @RequestMapping("/addNurse")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String addNurse(String nurseNum, String nurseName, String nursePhone, String nurseBirthday, String nurseAddress, String nurseEmail, int nurseAge, String nurseGender, String nursePosition, String nurseWorkspace, String nurseWorkDate, String nurseAbout) {
        Nurse nurse = new Nurse(nurseNum,nurseName,nursePhone,nurseBirthday,nurseAddress,nurseEmail,nurseAge,nurseGender,nursePosition,nurseWorkspace,nurseWorkDate,nurseAbout,"123",2500,"可派遣");
        if (nurse != null) {
            nurseService.addNurse(nurse);
            return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //修改护士信息
    @RequestMapping("/updateNurse")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String updateNurse(String nursePhone, String nurseAddress, String nurseEmail, String nursePosition, String nurseWorkspace, String nurseWorkDate, String nurseAbout, String nursePassword, double nurseMoney, String nurseNum) {
        System.out.println(nurseNum);
        int updateNurse = nurseService.updateNurse(nursePhone,nurseAddress,nurseEmail,nursePosition,nurseWorkspace,nurseWorkDate,nurseAbout,nursePassword,nurseMoney,nurseNum);
        if (updateNurse > 0) {
            return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //查看所有护士
    @RequestMapping("/nurses")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String allNurse(Model model) {
        List<Nurse> nurses = new ArrayList<>();
        try {
            nurses = nurseMapper.findAll();
        }catch (Exception e){
            return "personnel/error";
        }
        model.addAttribute("nurses",nurses);
        return "personnel/nurse/nurses";
    }


    //查看所有护士详细信息
    @RequestMapping("/nurseInfo")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String nurseInfo(Model model) {
        List<Nurse> nurses = new ArrayList<>();
        nurses = nurseMapper.findAll();
        model.addAttribute("nurses", nurses);
        return "personnel/nurse/aboutNurse";
    }

    //删除护士信息
    @RequestMapping("/deleteNurse")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String deleteNurse(String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                nurseService.deleteNurseByNurseNum(Collections.singletonList(strs[i]));
            } catch (Exception e) {
                return "personnel/error";
            }
        }
        return "personnel/nurse/nurses";
    }

    //修改护士现状
    @RequestMapping("/editNurseNowState")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String editNurseNowState(String nurseState,String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                nurseService.editNurseNowState(nurseState,Collections.singletonList(strs[i]));
            } catch (Exception e) {
                return "personnel/error";
            }
        }
        return "personnel/nurse/nurses";
    }

    //查询编号是否存在
    @RequestMapping("/queryNum")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    @ResponseBody
    public Nurse queryNum(String nurseNumber,Model model) {
        Nurse nurseNum = nurseMapper.findByNurseNum(nurseNumber);
        if (nurseNum==null){
            Nurse ns = new Nurse();
            ns.setNurseNum("编号不存在");
            return ns;
        }else {
            return nurseNum;
        }

    }
}
