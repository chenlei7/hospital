package com.sxxy.hospital.personnel.controller;

import com.sxxy.hospital.personnel.entity.Attendance;
import com.sxxy.hospital.personnel.mapper.AttendanceMapper;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceMapper attendanceMapper;
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
}
