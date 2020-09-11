package com.sxxy.hospital.personnel.mapper;

import com.sxxy.hospital.personnel.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorMapper extends JpaRepository<Doctor,Object> {
    //用户登录
    Doctor findByDoctorNumAndAndDoctorPassword(String doctorNum,String doctorPassword);
}
