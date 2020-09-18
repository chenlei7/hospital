package com.sxxy.hospital.financial.service.impl;

import com.sxxy.hospital.financial.mapper.StatementsMapper;
import com.sxxy.hospital.financial.service.WageService;
import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.entity.Nurse;
import com.sxxy.hospital.personnel.entity.Other;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import com.sxxy.hospital.personnel.mapper.NurseMapper;
import com.sxxy.hospital.personnel.mapper.OtherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 工资的发放
 */
@Service
public class WageServiceImpl implements WageService {
    //注入Doctor的dao接口
    @Autowired
    DoctorMapper doctorMapper;
    //注入Nurse的dao接口
    @Autowired
    NurseMapper nurseMapper;
    //注入other的dao接口
    @Autowired
    OtherMapper otherMapper;
    //注入财务的mapper接口
    @Autowired
    StatementsMapper statementsMapper;

    //格式化时间
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//    @Scheduled(fixedDelay = 60*60*1000)
    @Scheduled(cron = "0 0 9 1 * ?")//每月1号9点分发工资
    public void DoctorWage(){
        String time = format.format(new Date());
        //获取所有医生的信息
        List<Doctor> doctors = doctorMapper.findAll();
        //将医生有关信息和工资添加到财务表中
        for (Doctor doctor:doctors){
            statementsMapper.add(doctor.getDoctorNum(),doctor.getDoctorName(),doctor.getDoctorPosition()+"医生","工资","基本工资",time,0,doctor.getDoctorMoney());
        }
    }

    @Scheduled(cron = "0 0 9 1 * ?")//每月1号9点分发工资
    public void NurseWage(){
        String time = format.format(new Date());
        //获取所有护士的信息
        List<Nurse> nurses = nurseMapper.findAll();
        //将护士有关信息和工资添加到财务表中
        for (Nurse nurse:nurses){
            statementsMapper.add(nurse.getNurseNum(),nurse.getNurseName(),nurse.getNursePosition()+"护士","工资","基本工资",time,0,nurse.getNurseMoney());
        }
    }

    @Scheduled(cron = "0 0 9 1 * ?")//每月1号9点分发工资
    public void OtherWage(){
        String time = format.format(new Date());
        //获取所有其他人员的信息
        List<Other> nurses = otherMapper.findAll();
        //将其他人员有关信息和工资添加到财务表中
        for (Other other:nurses){
           statementsMapper.add(other.getOtherNum(),other.getOtherName(),other.getOtherPosition(),"工资","基本工资",time,0,other.getOtherMoney());
        }
    }
}
