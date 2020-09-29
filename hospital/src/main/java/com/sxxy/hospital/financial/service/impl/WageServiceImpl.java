package com.sxxy.hospital.financial.service.impl;

import com.sxxy.hospital.financial.mapper.StatementsMapper;
import com.sxxy.hospital.financial.mapper.WageMapper;
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
import java.util.Map;

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
    @Autowired
    WageMapper wageMapper;

    //格式化时间
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//    @Scheduled(fixedDelay = 60*60*1000)
    @Scheduled(cron = "0 0 0 L * ?")//每月28号9点分发工资
    public void DoctorWage(){
        String time = format.format(new Date());
        String date = sdf.format(new Date());
        int m ;
        //获取所有医生的信息
        List<Doctor> doctors = doctorMapper.findAll();
        //将医生有关信息和工资添加到财务表中
        for (Doctor doctor:doctors){
            m=wageMapper.findByNum(doctor.getDoctorNum(),date);
            if (m>0){
                statementsMapper.add(doctor.getDoctorNum(),doctor.getDoctorName(),doctor.getDoctorPosition()+"医生","工资","基本工资:"+doctor.getDoctorMoney()+";缺勤:-"+(m*50),time,0,doctor.getDoctorMoney()-(m*50));
            }else {
                statementsMapper.add(doctor.getDoctorNum(),doctor.getDoctorName(),doctor.getDoctorPosition()+"医生","工资","基本工资:"+doctor.getDoctorMoney(),time,0,doctor.getDoctorMoney());

            }
        }
    }
//    @Scheduled(fixedDelay = 60*60*1000)
    @Scheduled(cron = "0 0 0 L * ?")//每月28号9点分发工资
    public void NurseWage(){
        String time = format.format(new Date());
        String date = sdf.format(new Date());
        int m =0;
        //获取所有护士的信息
        List<Nurse> nurses = nurseMapper.findAll();
        //将护士有关信息和工资添加到财务表中
        for (Nurse nurse:nurses){
            m=wageMapper.findByNum(nurse.getNurseNum(),date);
            if (m>0){
                statementsMapper.add(nurse.getNurseNum(),nurse.getNurseName(),nurse.getNursePosition()+"护士","工资","基本工资:"+nurse.getNurseMoney()+";缺勤:-"+(m*50),time,0,nurse.getNurseMoney()-(m*50));
            }else {
                statementsMapper.add(nurse.getNurseNum(),nurse.getNurseName(),nurse.getNursePosition()+"护士","工资","基本工资:"+nurse.getNurseMoney(),time,0,nurse.getNurseMoney());
            }
        }
    }

    @Scheduled(cron = "0 0 0 L * ?")//每月28号9点分发工资
//@Scheduled(fixedDelay = 60*60*1000)
    public void OtherWage(){
        String time = format.format(new Date());
        String date = sdf.format(new Date());
        int m =0;
        //获取所有其他人员的信息
        List<Other> nurses = otherMapper.findAll();
        //将其他人员有关信息和工资添加到财务表中
        for (Other other:nurses){
            m=wageMapper.findByNum(other.getOtherNum(),date);
            if(m>0){
                statementsMapper.add(other.getOtherNum(),other.getOtherName(),other.getOtherPosition(),"工资","基本工资:"+other.getOtherMoney()+";缺勤:-"+(m*50),time,0,other.getOtherMoney()-(m*50));
            }else {
                statementsMapper.add(other.getOtherNum(),other.getOtherName(),other.getOtherPosition(),"工资","基本工资:"+other.getOtherMoney(),time,0,other.getOtherMoney());
            }
        }
    }
}
