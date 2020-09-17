package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.patient.entity.Bill;
import com.sxxy.hospital.patient.entity.Illness;
import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.BillMapper;
import com.sxxy.hospital.patient.mapper.IllnessMapper;
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

    @Autowired
    BillMapper billMapper;

    @Autowired
    IllnessMapper illnessMapper;

    //主页面
    @RequestMapping("/index")
    public String index(){
        return "patient/index";
    }

    //网上预约挂号主页面
    @RequestMapping("/register")
    public String register(){
        return "patient/register";
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
        patients = patientMapper.findAllPatient();
        model.addAttribute("patients",patients);
        return "patient/patientsInfo";
    }

    //真正的添加病人
    @PostMapping("/patientAdd")
    public String patientAdd(Patient patient){
        try {
            patientMapper.save(patient);
            Bill bill = new Bill();
            bill.setBillNum(patient.getPatientNum());
            bill.setBillRegisterCost(15.00);
            bill.setBillCountCost(15.00);
            billMapper.save(bill);
        }catch (Exception e){
            return "patient/error";
        }
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
        //修改病人信息表
        int a = patientService.PatientUpdate(patient);
        //添加病情表
        Illness illness = new Illness();
        illness.setIllnessNum(patient.getPatientIllnessNum());
        illnessMapper.save(illness);
        if (a > 0){
            return  "redirect:/patient/patientsInfo";
        }else {
            return "patient/error";
        }

    }

    //网上挂号的全部病人信息
    @RequestMapping("/registerAll")
    public String registerAll(Model model){
        List<Patient> patientss = new ArrayList<>();
        patientss = patientMapper.findAllRegister();
        model.addAttribute("patientss",patientss);
        return "patient/registerAll";
    }


}
