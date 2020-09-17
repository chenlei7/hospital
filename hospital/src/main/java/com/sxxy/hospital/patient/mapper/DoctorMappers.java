package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.personnel.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//医生
@Repository
public interface DoctorMappers extends JpaRepository<Doctor,Object> {

    //根据科室查找医生
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "select * from doctor_info where doctor_position=:room")
    List<Doctor> findADoctorByRoom(@Param("room")String room);

    //根据医生编号查找医生的工作地方
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "select * from doctor_info where doctor_num=:doctorNum")
    List<Doctor> findADoctorByDoctorNum(@Param("doctorNum")String doctorNum);
}
