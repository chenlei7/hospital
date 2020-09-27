package com.sxxy.hospital.personnel.controller;

import com.sxxy.hospital.personnel.entity.Attendance;
import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.entity.Nurse;
import com.sxxy.hospital.personnel.entity.Other;
import com.sxxy.hospital.personnel.mapper.AttendanceMapper;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import com.sxxy.hospital.personnel.mapper.NurseMapper;
import com.sxxy.hospital.personnel.mapper.OtherMapper;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.text.resources.FormatData;

import javax.print.Doc;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceMapper attendanceMapper;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    NurseMapper nurseMapper;
    @Autowired
    OtherMapper otherMapper;
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    @RequestMapping("/goAttendance")
    public String attendance(Attendance attendance){
            return "personnel/attendance/attendance";

    }

    //考勤记录
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    @RequestMapping("/doAttendance")
    public String goAttendance(Attendance attendance){
        if(null!=attendance){
            Attendance i = attendanceMapper.save(attendance);
            return "personnel/success";
        }else {
            return "personnel/error";
        }
    }

    //考勤查询
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    @RequestMapping("/allAttendance")
    public String findAttendance(Model model){
        List<Attendance> attendances = new ArrayList<>();
        attendances = attendanceMapper.findAll();
        model.addAttribute("attendances",attendances);
        return "personnel/attendance/allAttendance";
    }

    //考勤验证
    @RequestMapping("/queryName")
    @RequiresRoles(value={"admin","dept"},logical = Logical.OR)
    @ResponseBody
    public Attendance queryName(String identity,String attendanceName,Model model) {
        if (identity.equals("医生")){
            try {
                Doctor doctor =  doctorMapper.findByDoctorName(attendanceName);
                Attendance attendance = new Attendance();
                attendance.setAttendanceDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
                attendance.setAttendanceNum(doctor.getDoctorNum());
                return  attendance;
            }catch (Exception e){
                Attendance attendance = new Attendance();
                attendance.setAttendanceNum("该人员不存在");
                return attendance;
            }
        }else if(identity.equals("护士")){
            try {
                Nurse nurse =  nurseMapper.findByNurseName(attendanceName);
                Attendance attendance = new Attendance();
                attendance.setAttendanceDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
                attendance.setAttendanceNum(nurse.getNurseNum());
                return  attendance;
            }catch (Exception e){
                Attendance attendance = new Attendance();
                attendance.setAttendanceNum("该人员不存在");
                return attendance;
            }
        }else {
            try {
                Other other =  otherMapper.findByOtherName(attendanceName);
                Attendance attendance = new Attendance();
                attendance.setAttendanceDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString());
                attendance.setAttendanceNum(other.getOtherNum());
                return  attendance;
            }catch (Exception e){
                Attendance attendance = new Attendance();
                attendance.setAttendanceNum("该人员不存在");
                return attendance;
            }
        }
    }
}
