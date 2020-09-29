package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.equipment.entity.Room;
import com.sxxy.hospital.equipment.mapper.RoomMapper;
import com.sxxy.hospital.patient.entity.Bill;
import com.sxxy.hospital.patient.entity.Illness;
import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.*;
import com.sxxy.hospital.patient.service.PatientService;
import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.entity.Nurse;
import com.sxxy.hospital.personnel.mapper.NurseMapper;
import com.sxxy.hospital.personnel.service.NurseService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    RoomMapper roomMapper;

    @Autowired
    RoomMappers roomMappers;

    @Autowired
    DoctorMappers doctorMappers;

    @Autowired
    NurseService nurseService;
    @Autowired
    NurseMapper nurseMapper;

    @Autowired
    NurseMappers nurseMappers;

    //主页面
    @RequestMapping("/index")
    public String index(Model model){
        List<Patient> patients = new ArrayList<>();
        patients = patientMapper.findAllPatient();
        model.addAttribute("patients",patients);
        //查询出可派遣的护士
        List<Nurse> nurses = nurseMappers.findOneNurse();
        model.addAttribute("nurses",nurses);
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
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @RequestMapping("/patientsInfo")
    public String patientsInfo(Model model){
        List<Patient> patients = new ArrayList<>();
        patients = patientMapper.findAllPatient();
        model.addAttribute("patients",patients);
        //查询出可派遣的护士
        List<Nurse> nurses = nurseMappers.findOneNurse();
        model.addAttribute("nurses",nurses);
        return "patient/patientsInfo";
    }

    //真正的添加病人
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @PostMapping("/patientAdd")
    public String patientAdd(Patient patient){
        try {
            //更据医生编号去查找工作的地方
            List<Doctor> doctors = doctorMappers.findADoctorByDoctorNum(patient.getPatientDoctorNum());
            String doctorNum1 = doctors.get(0).getDoctorWorkspace();
            //根据工作地点查找工作房间编号
            List<Room> rooms = roomMappers.findRoomByName(doctorNum1);
            String roomNum = rooms.get(0).getRoomNum();
            //把医生工作的地方存入patient对象
            patient.setPatientRoomNum(roomNum);
            patientMapper.save(patient);
            Bill bill = new Bill();
            bill.setBillNum(patient.getPatientBillNum());
            bill.setBillRegisterCost(15.00);
            bill.setBillCountCost(15.00);
            bill.setBillDrugCost(0.00);
            bill.setBillHospitalizationCost(0.00);
            bill.setBiiInspectCost(0.00);
            bill.setBill_medicalInsurance(0.00);
            bill.setBillPaid(15.00);
            bill.setBill_date(patient.getPatientComeDate());
            billMapper.save(bill);
        }catch (Exception e){
            return "patient/error";
        }
        return "patient/doctor/doctorSuccess";
    }


    //跳转页面
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @RequestMapping("/addPatient")
    public String addPatient(Model model){
        List<Doctor> doctors = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();
        rooms = roomMappers.findAllRoom();
        model.addAttribute("rooms", rooms);
        return "patient/patientAdd";
    }

    //修改病人信息
    @PostMapping("/patientUpadte")
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    public  String patientUpadte(Patient patient){
        System.out.println(patient);
        //得到病情编号判断是否存在
        String illnes = patient.getPatientIllnessNum();
        List<Illness> il = illnessMapper.findIllnessByNum(illnes);
        if(il != null && !il.equals("")){
            //修改病人信息表
            int a = patientService.PatientUpdate(patient);
            String nurseState = "已派遣";
            String nurseNum = patient.getPatientNurseNum();
            //改变护士状态
            if (nurseNum != null && !nurseNum.equals("")){
                nurseMappers.editNurseNowState(nurseState,nurseNum);
            }
            if (a > 0){
                return  "redirect:/patient/patientsInfo";
            }else {
                return "patient/error";
            }
        }else {
            //修改病人信息表
            int a = patientService.PatientUpdate(patient);
            String nurseState = "已派遣";
            String nurseNum = patient.getPatientNurseNum();
            //改变护士状态
            if (nurseNum != null && !nurseNum.equals("")){
                nurseMappers.editNurseNowState(nurseState,nurseNum);
            }
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
    }

    //网上挂号的全部病人信息
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @RequestMapping("/registerAll")
    public String registerAll(Model model){
        List<Patient> patientss = new ArrayList<>();
        patientss = patientMapper.findAllRegister();
        model.addAttribute("patientss",patientss);
        return "patient/registerAll";
    }


    //修改护士信息
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @RequestMapping("/updateNurse")
    public String updateNurse(String nursePhone, String nurseAddress, String nurseEmail, String nursePosition, String nurseWorkspace, String nurseWorkDate, String nurseAbout, String nursePassword, double nurseMoney, String nurseNum) {
        System.out.println(nurseNum);
        int updateNurse = nurseService.updateNurse(nursePhone,nurseAddress,nurseEmail,nursePosition,nurseWorkspace,nurseWorkDate,nurseAbout,nursePassword,nurseMoney,nurseNum);
        if (updateNurse > 0) {
            return "personnel/success";
        } else {
            return "personnel/error";
        }
    }

    //查看所有护士
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @RequestMapping("/nurses")
    public String allNurse(Model model) {
        List<Nurse> nurses = new ArrayList<>();
        try {
            nurses = nurseMapper.findAll();
        }catch (Exception e){
            return "personnel/error";
        }
        model.addAttribute("nurses",nurses);
        return "patient/nurse/nurses";
    }

    //根据id查询一个病人的信息
    @ResponseBody
    @GetMapping("/findOnePatient")
    public List<Patient> findOnePatient(int patientId, HttpServletRequest request) {
        System.out.println("....." + patientId);
        List<Patient> patient = new ArrayList<>();
        patient = patientMapper.findOnePatient(patientId);
        if (patient == null && patient.equals("")) {
            return null;
        }
        return patient;
    }
}
