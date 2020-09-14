package com.sxxy.hospital.personnel.controller;


import com.sxxy.hospital.personnel.entity.Nurse;
import com.sxxy.hospital.personnel.mapper.NurseMapper;
import com.sxxy.hospital.personnel.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
    public String addNurse(String nurseNum, String nurseName, String nursePhone, String nurseBirthday, String nurseAddress, String nurseEmail, int nurseAge, String nurseGender, String nursePosition, String nurseWorkspace, String nurseWorkDate, String nurseAbout) {
        Nurse nurse = new Nurse(nurseNum,nurseName,nursePhone,nurseBirthday,nurseAddress,nurseEmail,nurseAge,nurseGender,nursePosition,nurseWorkspace,nurseWorkDate,nurseAbout,"123",4000,"可派遣");
        if (nurse != null) {
            nurseService.addNurse(nurse);
            return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //修改护士信息
    @RequestMapping("/updateNurse")
    public String updateNurse() {
        if (1 > 0) {
            return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //查看所有护士
    @RequestMapping("/nurses")
    public String allNurse(Model model) {
        List<Nurse> nurses = new ArrayList<>();
        nurses = nurseMapper.findAll();
        model.addAttribute("nurses",nurses);
        return "personnel/nurse/nurses";
    }

    //查看所有护士详细信息
    @RequestMapping("/nurseInfo")
    public String nurseInfo(Model model) {
        return "personnel/nurse/aboutNurse";
    }

    //删除护士信息
    @RequestMapping("/deleteNurse")
    public String deleteNurse(String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {

            } catch (Exception e) {
                return "personnel/error";
            }
        }
        return "personnel/nurse/nurses";
    }

    //修改护士现状
    @RequestMapping("/editNurseNowState")
    public String editNurseNowState(String doctorState,String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
            } catch (Exception e) {
                return "personnel/error";
            }
        }
        return "personnel/nurse/nurses";
    }
}
