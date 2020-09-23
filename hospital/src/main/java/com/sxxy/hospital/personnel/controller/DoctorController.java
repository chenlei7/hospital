package com.sxxy.hospital.personnel.controller;

import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import com.sxxy.hospital.personnel.service.DoctorService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    DoctorMapper doctorMapper;


    //增加医生
    @RequestMapping("/addDoctor")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String addDoctor(String doctorNum, String doctorName, String doctorPhone, String doctorBirthday, String doctorAddress, String doctorEmail, int doctorAge, String doctorGender, String doctorPosition, String doctorWorkspace, String doctorWorkDate, String doctorAbout) {
        Doctor addDoctor = new Doctor(doctorNum, doctorName, doctorPhone, doctorBirthday, doctorAddress, doctorEmail, doctorAge, doctorGender, doctorPosition, doctorWorkspace, doctorWorkDate, doctorAbout, "123", "可出诊",8000);
        if (addDoctor != null) {
                doctorService.addDoctor(addDoctor);
                return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //编辑医生信息
    @RequestMapping("/updateDoctor")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String updateDoctor(String doctorPhone, String doctorAddress, String doctorEmail, String doctorPosition, String doctorWorkspace, String doctorWorkDate, String doctorAbout,String doctorPassword,double doctorMoney,String doctorNum)  {
        int updateDoctor = doctorService.updateDoctor(doctorPhone, doctorAddress, doctorEmail, doctorPosition, doctorWorkspace, doctorWorkDate, doctorAbout, doctorPassword, doctorMoney,doctorNum);
        if (updateDoctor > 0) {
            return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //查看所有医生
    @RequestMapping("/doctors")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String allDoctor(Model model) {
        List<Doctor> doctors = new ArrayList<>();
        try {
            doctors = doctorMapper.findAll();
        }catch (Exception e){
            return "personnel/error";
        }
        model.addAttribute("doctors", doctors);
        return "personnel/doctor/doctors";
    }

    //查看所有医生详细信息
    @RequestMapping("/doctorInfo")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String doctorInfo(Model model) {
        List<Doctor> doctors = new ArrayList<>();
        doctors = doctorMapper.findAll();
        model.addAttribute("doctors", doctors);
        return "personnel/doctor/aboutDoctor";
    }

    //删除医生信息
    @RequestMapping("/deleteDoctor")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    public String deleteDoctor(String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                doctorService.deleteDoctorByDoctorNum(Collections.singletonList(strs[i]));
            } catch (Exception e) {
                return "personnel/error";
            }
        }
        return "personnel/doctor/doctors";
    }

    //修改医生现状
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    @RequestMapping("/editDoctorNowState")
    public String editDoctorNowState(String doctorState,String tag) {
        String[] strs = tag.split(",");
        for (int i = 0; i < strs.length; i++) {
            try {
                doctorService.editDoctorNowState(doctorState,Collections.singletonList(strs[i]));
            } catch (Exception e) {
                return "personnel/error";
            }
        }
        return "personnel/doctor/doctors";
    }


}
