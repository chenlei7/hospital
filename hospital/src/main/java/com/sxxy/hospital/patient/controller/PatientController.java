package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.PatientMapper;
import com.sxxy.hospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientMapper patientMapper;

    @Autowired
    PatientService patientService;

    //主页面
    @RequestMapping("/index")
    public String index(){
        return "patient/index";
    }

    //错误页面
    @RequestMapping("/error")
    public String error(){
        return "patient/error";
    }

    //查询全部病人信息
    @RequestMapping("/patientsInfo")
    public String patientsInfo(Model model){
        List<Patient> patients = new ArrayList<>();
        patients = patientMapper.findAll();
        model.addAttribute("patients",patients);
        return "patient/patientsInfo";
    }

    //真正的添加病人
    @PostMapping("/patientAdd")
    public String patientAdd(Patient patient){
        patientMapper.save(patient);
        return "patient/patientAdd";
    }

    //跳转页面
    @RequestMapping("/addPatient")
    public String addPatient(){
        return "patient/patientAdd";
    }

    //修改病人信息
    @PostMapping("/patientUpadte")
    public  String patientUpadte(Patient patient){
        System.out.println(patient);
        int a = patientService.PatientUpdate(patient);
        if (a > 0){
            return  "redirect:/patient/patientsInfo";
        }else {
            return "patient/error";
        }

    }

}
