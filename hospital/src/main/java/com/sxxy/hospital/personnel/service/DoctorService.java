package com.sxxy.hospital.personnel.service;

import com.sxxy.hospital.personnel.entity.Doctor;

import java.util.List;

public interface DoctorService {
    //增加医生
    Doctor addDoctor(Doctor doctor);

    //编辑医生信息
    int updateDoctor(String doctorPhone, String doctorAddress, String doctorEmail, String doctorPosition, String doctorWorkspace, String doctorWorkDate, String doctorAbout,String doctorPassword,double doctorMoney,String doctorNum);

    //删除医生信息
    int deleteDoctorByDoctorNum(List<String> delNum);

    //修改医生现状
    int editDoctorNowState(String doctorState,List<String> editNum);
}
