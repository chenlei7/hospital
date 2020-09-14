package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("patient")
public class PatientController {
    @Autowired
    PatientMapper patientMapper;
    //主页面
    @RequestMapping("index")
    public String index(){
        return "patient/index";
    }

    //查询全部病人信息
    @RequestMapping("patientsInfo")
    public String patientsInfo(Model model){
        List<Patient> patients = new ArrayList<>();
        patients = patientMapper.findAll();
        model.addAttribute("patients",patients);
        return "patient/patientsInfo";
    }


}
