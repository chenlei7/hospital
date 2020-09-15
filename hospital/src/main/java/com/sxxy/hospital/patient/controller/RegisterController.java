package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.PatientMapper;
import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//用户网上挂号
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    DoctorMapper doctorMapper;

    //增加网上预约
    @PostMapping("/registerAdd")
    public String registerAdd(Patient patient){
        try {
            patientMapper.save(patient);
        }catch (Exception e){
            return "jump/flase";
        }
        return "jump/success";
    }

    //查看所有医生
    @RequestMapping("/doctors")
    public String allDoctor(Model model) {
        List<Doctor> doctors = new ArrayList<>();
        try {
            doctors = doctorMapper.findAll();
        }catch (Exception e){
            return "personnel/error";
        }
        model.addAttribute("doctors", doctors);
        return "patient/register";
    }

    //挂号界面
    @RequestMapping("/registered")
    public String goRegistered(){
        return "patient/register";
    }

}
