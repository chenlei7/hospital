package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.equipment.entity.Room;
import com.sxxy.hospital.equipment.mapper.RoomMapper;
import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.PatientMapper;
import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    RoomMapper roomMapper;

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
    public String goRegistered(Model model){
        List<Doctor> doctors = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();
        rooms = roomMapper.findAll();
        doctors = doctorMapper.findAll();
        model.addAttribute("doctors",doctors);
        model.addAttribute("rooms",rooms);
        return "patient/register";
    }

    @GetMapping("/findDoctor")
    public String findDoctor(){
        return null;
    }

}
