package com.sxxy.hospital.personnel.mapper;

import com.sxxy.hospital.personnel.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DoctorMapper extends JpaRepository<Doctor,Object> {
    //修改医生信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update doctor_info  set doctor_phone=:doctorPhone,doctor_address=:doctorAddress,doctor_email=:doctorEmail,doctor_position=:doctorPosition,doctor_workspace=:doctorWorkspace,doctor_work_date=:doctorWorkDate,doctor_about=:doctorAbout,doctor_password=:doctorPassword where doctor_num =:doctorNum")
    int updateDoctor(@Param("doctorPhone")String doctorPhone,@Param("doctorAddress")String doctorAddress,@Param("doctorEmail")String doctorEmail,
                     @Param("doctorPosition")String doctorPosition,@Param("doctorWorkspace")String doctorWorkspace,@Param("doctorWorkDate")String doctorWorkDate,
                     @Param("doctorAbout")String doctorAbout,@Param("doctorPassword")String doctorPassword,@Param("doctorNum")String doctorNum);

    //删除医生信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "delete  from doctor_info  where  doctor_num in (:delNum) ")
    int deleteDoctorByDoctorNum(@Param("delNum") List<String> delNum);

    //修改医生现状
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update doctor_info set doctor_state=:doctorState  where  doctor_num in (:editNum) ")
    int editDoctorNowState(@Param("doctorState")String doctorState, @Param("editNum") List<String> editNum);
}
