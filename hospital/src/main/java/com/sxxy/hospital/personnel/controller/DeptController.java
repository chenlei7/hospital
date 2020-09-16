package com.sxxy.hospital.personnel.controller;



import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.PatientMapper;
import com.sxxy.hospital.personnel.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
            model.addAttribute("patients",patients);
            int patientNoLeave = 0;
            int nowPatientNum = 0;
            int yesterdayNum = 0;
            //今日
            String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
            //昨日
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -1);

            for (int i = 0; i < patients.size(); i++) {
                if(patients.get(i).getPatientLeaveDate()!=null){
                    patientNoLeave++;
                }
                if(patients.get(i).getPatientComeDate().equals(nowDate)){
                    nowPatientNum++;
                }
                if(patients.get(i).getPatientComeDate().equals(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()))){
                    yesterdayNum++;
                }
            }
            System.out.println(yesterdayNum);
            model.addAttribute("nowPatientNum",nowPatientNum);
            model.addAttribute("yesterdayNum",yesterdayNum);
            model.addAttribute("patientNoLeave",patientNoLeave);

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
