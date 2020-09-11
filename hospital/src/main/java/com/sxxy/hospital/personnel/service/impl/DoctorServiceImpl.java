package com.sxxy.hospital.personnel.service.impl;

import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import com.sxxy.hospital.personnel.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    //注入接口
    @Autowired
    DoctorMapper doctorMapper;
    //医生登录
    @Override
    public Doctor doctorLodin(String doctorNum, String doctorPassword) {
        return doctorMapper.findByDoctorNumAndAndDoctorPassword(doctorNum,doctorPassword);
    }
}
