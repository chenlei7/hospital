package com.sxxy.hospital.personnel.service;

import com.sxxy.hospital.personnel.entity.Doctor;
import org.springframework.data.repository.query.Param;

public interface DoctorService {
    //医生登录
    Doctor doctorLodin(String doctorNum, String doctorPassword );
}
