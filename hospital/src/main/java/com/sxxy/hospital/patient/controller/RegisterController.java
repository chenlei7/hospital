package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.equipment.entity.Room;
import com.sxxy.hospital.equipment.mapper.RoomMapper;
import com.sxxy.hospital.patient.entity.Bill;
import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.BillMapper;
import com.sxxy.hospital.patient.mapper.PatientMapper;
import com.sxxy.hospital.patient.mapper.RoomMappers;
import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sxxy.hospital.patient.mapper.DoctorMappers;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
    @Autowired
    DoctorMappers doctorMappers;
    @Autowired
    RoomMappers roomMappers;
    @Autowired
    BillMapper billMapper;

    //增加网上预约
    @PostMapping("/registerAdd")
    public String registerAdd(Patient patient) {
        try {
            patientMapper.save(patient);
        } catch (Exception e) {
            return "redirect:/jump/false";
        }
        return "redirect:/jump/success";
    }

    //查看所有医生
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @RequestMapping("/doctors")
    public String allDoctor(Model model) {
        List<Doctor> doctors = new ArrayList<>();
        try {
            doctors = doctorMapper.findAll();
        } catch (Exception e) {
            return "personnel/error";
        }
        model.addAttribute("doctors", doctors);
        return "patient/register";
    }

    //挂号界面
    @RequestMapping("/registered")
    public String goRegistered(Model model) {
        List<Doctor> doctors = new ArrayList<>();
        List<Room> rooms = new ArrayList<>();
        rooms = roomMappers.findAllRoom();
        doctors = doctorMapper.findAll();
        model.addAttribute("doctors", doctors);
        model.addAttribute("rooms", rooms);
        return "patient/register";
    }


    //科室联动医生
    @ResponseBody
    @GetMapping("/findDoctor")
    public List<Doctor> findDoctor(String room) {
        //调用业务返回根据科室查询的医生结果
        System.out.println("....我是科室" + room);
        System.out.println(doctorMappers.findADoctorByRoom(room));
        return doctorMappers.findADoctorByRoom(room);

    }


    /**
     * 医院确认挂号信息，根根据ID去修改病人信息
     *
     * @param patientId
     * @param patientNums
     * @param patientBillNum
     * @param patientDoctorNum
     * @param request
     * @return
     */
    @RequestMapping("/registerUpdate")
    public String registerUpdate(String patientId, String patientNums, String patientBillNum, String patientDoctorNum, HttpServletRequest request) {
        System.out.println(patientNums + "...." + patientId);
        //int a = patientMapper.registerUpdate(patientNums,patientId);
        String doctorNum = (String) request.getSession().getAttribute("doctorNum");
        //专家号
        if (doctorNum.length() > 1) {
            //更据医生编号去查找工作的地方
            List<Doctor> doctors = doctorMappers.findADoctorByDoctorNum(doctorNum);
            String doctorNum1 = doctors.get(0).getDoctorWorkspace();
            //根据工作地点查找工作房间编号
            List<Room> rooms = roomMappers.findRoomByName(doctorNum1);
            String roomNum = rooms.get(0).getRoomNum();
            int a = patientMapper.registerUpdate(patientId, patientNums, patientBillNum, roomNum, doctorNum);
            System.out.println("到" + patientId + "," + patientNums + "," + patientBillNum + "," + roomNum + "," + doctorNum);
            System.out.println("是我：：" + a);
            if (a > 0) {
                Bill bill = new Bill();
                bill.setBillNum(patientBillNum);
                bill.setBillRegisterCost(200.00);
                bill.setBillCountCost(200.00);
                bill.setBillDrugCost(0.00);
                bill.setBillHospitalizationCost(0.00);
                bill.setBiiInspectCost(0.00);
                bill.setBill_medicalInsurance(0.00);
                bill.setBillPaid(00.00);
                Date date = new Date();//获取当前的日期
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String str = df.format(date);//获取String类型的时间
                bill.setBill_date(str);
                billMapper.save(bill);
                return "redirect:/jump/doctorSuccess";
            } else {
                return "patient/error";
            }
        } else { //不是专家号
            //更据医生编号去查找工作的地方
            List<Doctor> doctor = doctorMappers.findADoctorByDoctorNum(patientDoctorNum);
            String doctorNum1 = doctor.get(0).getDoctorWorkspace();
            System.out.println("doctorNum1"+doctorNum1);
            //根据工作地点查找工作房间编号
            List<Room> rooms = roomMappers.findRoomByName(doctorNum1);
            System.out.println("rooms"+rooms);
            String roomNum = rooms.get(0).getRoomNum();
            int b = patientMapper.registerUpdate(patientId, patientNums, patientBillNum, roomNum, patientDoctorNum);
            System.out.println("到了" + patientId + "," + patientNums + "," + patientBillNum + "," + roomNum + "," + patientDoctorNum);
            System.out.println("我不是专家号：" + b);
            if (b > 0) {
                Bill bill = new Bill();
                bill.setBillNum(patientBillNum);
                bill.setBillRegisterCost(15.00);
                bill.setBillCountCost(15.00);
                bill.setBillDrugCost(0.00);
                bill.setBillHospitalizationCost(0.00);
                bill.setBiiInspectCost(0.00);
                bill.setBill_medicalInsurance(0.00);
                bill.setBillPaid(00.00);
                Date date = new Date();//获取当前的日期
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                String str = df.format(date);//获取String类型的时间
                bill.setBill_date(str);
                billMapper.save(bill);
                return "redirect:/jump/doctorSuccess";
            } else {
                return "patient/error";
            }
        }


    }


    //根据id查询一个病人的信息
    @ResponseBody
    @GetMapping("/findOnePatient")
    public List<Doctor> findOnePatient(int patientId, HttpServletRequest request) {
        System.out.println("....." + patientId);
        List<Patient> patient = new ArrayList<>();
        patient = patientMapper.findOnePatient(patientId);
        //得到医生的编号
        String doctorNum = patient.get(0).getPatientDoctorNum();
        //存入session
        request.getSession().setAttribute("doctorNum", doctorNum);
        if (patient == null && patient.equals("")) {
            return null;
        }
        return doctorMappers.findADoctorByRoom(patient.get(0).getPatientRoomNum());
    }

    //根据用户名字和密码查询状态
    @RequestMapping("/myRegister")
    public String myRegister(String patientName,String patientPhone,Model model){
        List<Patient> list = patientMapper.findRegister(patientName,patientPhone);
        model.addAttribute("myState",list);
        return "patient/showRegisterState";
    }

}
