package com.sxxy.hospital.personnel.controller;

import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.PatientMapper;
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
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    PatientMapper patientMapper;
    //跳到登录界面
    @RequestMapping("/login")
    public String goLogin(){
        return "personnel/login";
    }

    //跳到首页
    @RequestMapping("/index")
    public String goIndex(Model model){
        List<Patient> patients = new ArrayList<>();
        patients = patientMapper.findAll();
        model.addAttribute("patients",patients);
        //病人住院数
        int patientNoLeave = 0;
        //今日病人数
        String nowDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString();
        int nowPatientNum = 0;
        //昨日病人数
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        int yesterdayNum = 0;
        //前天人数
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DATE, -2);
        int beforeYesterDayNum = 0;

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
            if(patients.get(i).getPatientComeDate().equals(new SimpleDateFormat("yyyy-MM-dd").format(calendar1.getTime()))){
                beforeYesterDayNum++;
            }
        }
        model.addAttribute("patientNoLeave",patientNoLeave);
        model.addAttribute("nowPatientNum",nowPatientNum);
        model.addAttribute("yesterdayNum",yesterdayNum);
        model.addAttribute("beforeYesterDayNum",beforeYesterDayNum);
        return "personnel/index";
    }


    /*
     * 医生模块，页面跳转
     * */
    //增加医生
    @RequestMapping("/addDoctor")
    public String goAddDoctor(){
        return "personnel/doctor/addDoctor";
    }

    //查看医生详细信息
    @RequestMapping("/aboutDoctor")
    public String goAboutDoctor(){
        return "personnel/doctor/aboutDoctor";
    }

    //修改医生信息
    @RequestMapping("/editDoctor")
    public String goEditDoctor(){
        return "personnel/doctor/editDoctor";
    }


    /*
     * 护士模块，页面跳转
     * */

    //增加护士
    @RequestMapping("/addNurse")
    public String goAddNurse(){
        return "personnel/nurse/addNurse";
    }

    //查看护士详细信息
    @RequestMapping("/aboutNurse")
    public String goAboutNurse(){
        return "personnel/nurse/aboutNurse";
    }

    //修护士信息
    @RequestMapping("/editNurse")
    public String goEditNurse(){
        return "personnel/nurse/editNurse";
    }


    /*
     * 其他人员模块，页面跳转
     * */

    //增加护士
    @RequestMapping("/addOther")
    public String goAddOther(){
        return "personnel/other/addOther";
    }

    //查看护士详细信息
    @RequestMapping("/aboutOther")
    public String goAboutOther(){
        return "personnel/other/aboutOther";
    }

    //修护士信息
    @RequestMapping("/editOther")
    public String goEditOther(){
        return "personnel/other/editOther";
    }
}
