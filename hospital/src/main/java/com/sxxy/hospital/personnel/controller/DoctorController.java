package com.sxxy.hospital.personnel.controller;

import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import com.sxxy.hospital.personnel.service.DoctorService;
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
    public String addDoctor(String doctorNum, String doctorName, String doctorPhone, String doctorBirthday, String doctorAddress, String doctorEmail, int doctorAge, String doctorGender, String doctorPosition, String doctorWorkspace, String doctorWorkDate, String doctorAbout) {
        Doctor addDoctor = new Doctor(doctorNum, doctorName, doctorPhone, doctorBirthday, doctorAddress, doctorEmail, doctorAge, doctorGender, doctorPosition, doctorWorkspace, doctorWorkDate, doctorAbout, "123", "可出诊");
        if (addDoctor != null) {
                doctorService.addDoctor(addDoctor);
                return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //修改医生信息
    @RequestMapping("/updateDoctor")
    public String updateDoctor(String doctorPhone, String doctorAddress, String doctorEmail, String doctorPosition, String doctorWorkspace, String doctorWorkDate, String doctorAbout, String doctorPassword, String doctorNum) {
        int updateDoctor = doctorService.updateDoctor(doctorPhone, doctorAddress, doctorEmail, doctorPosition, doctorWorkspace, doctorWorkDate, doctorAbout, doctorPassword, doctorNum);
        if (updateDoctor > 0) {
            return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //查看所有医生
    @RequestMapping("/doctors")
    public String allDoctor(Model model) {
        List<Doctor> doctors = new ArrayList<>();
        doctors = doctorMapper.findAll();
        model.addAttribute("doctors", doctors);
        return "personnel/doctor/doctors";
    }

    //查看所有医生详细信息
    @RequestMapping("/doctorInfo")
    public String doctorInfo(Model model) {
        List<Doctor> doctors = new ArrayList<>();
        doctors = doctorMapper.findAll();
        model.addAttribute("doctors", doctors);
        return "personnel/doctor/aboutDoctor";
    }

    //删除医生信息
    @RequestMapping("/deleteDoctor")
    public String deleteDoctor(String tag) {
        System.out.println(tag);
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
    @RequestMapping("/editDoctorNowState")
    public String editDoctorNowState(String doctorState,String tag) {
        System.out.println(tag);
        System.out.println(doctorState);
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
