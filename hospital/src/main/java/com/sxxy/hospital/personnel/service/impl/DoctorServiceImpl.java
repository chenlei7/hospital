package com.sxxy.hospital.personnel.service.impl;

import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.mapper.DoctorMapper;
import com.sxxy.hospital.personnel.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorMapper doctorMapper;

    //增加医生
    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorMapper.save(doctor);
    }

    //修改医生信息
    @Override
    public int updateDoctor(String doctorPhone, String doctorAddress, String doctorEmail, String doctorPosition, String doctorWorkspace, String doctorWorkDate, String doctorAbout,String doctorPassword,String doctorNum) {
        return doctorMapper.updateDoctor(doctorPhone, doctorAddress, doctorEmail, doctorPosition, doctorWorkspace, doctorWorkDate, doctorAbout, doctorPassword,doctorNum);
    }

    //删除医生信息
    @Override
    public int deleteDoctorByDoctorNum(List<String> delNum) {
        return doctorMapper.deleteDoctorByDoctorNum(delNum);
    }

    //修改医生现状
    @Override
    public int editDoctorNowState(String doctorState, List<String> editNum) {
        return doctorMapper.editDoctorNowState(doctorState,editNum);
    }
}
