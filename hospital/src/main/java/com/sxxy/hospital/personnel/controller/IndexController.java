package com.sxxy.hospital.personnel.controller;

import com.sxxy.hospital.patient.entity.Patient;

import com.sxxy.hospital.patient.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {
@Autowired
    PatientMapper patientMapper;

    @RequestMapping("/index")
    public String goIndex(Model model){
        List<Patient> patients = new ArrayList<>();
        patients = patientMapper.findAll();
        System.out.println(patients);
        model.addAttribute("patients",patients);


        return "personnel/index2";
    }
}
