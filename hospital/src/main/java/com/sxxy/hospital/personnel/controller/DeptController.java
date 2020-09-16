package com.sxxy.hospital.personnel.controller;



import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.PatientMapper;
import com.sxxy.hospital.personnel.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    //注入接口
    @Autowired
    DeptService deptService;
    @Autowired
    PatientMapper patientMapper;

    //部门登录
    @RequestMapping("/login")
    public String deptLogin(String deptNum, String deptPassword, Model model){
        if(deptService.deptLodin(deptNum,deptPassword)!=null) {
            List<Patient> patients = new ArrayList<>();
            patients = patientMapper.findAll();
            System.out.println(patients);
            model.addAttribute("patients",patients);
            return "personnel/index";
        }else {
            return "personnel/login";
        }
    }

    //查询部门  (代写)
    @RequestMapping("/allDept")
    public String allDept(String deptNum, String deptPassword){
        if(deptService.deptLodin(deptNum,deptPassword)!=null) {
            return "personnel/index";
        }else {
            return "personnel/login";
        }
    }


}
