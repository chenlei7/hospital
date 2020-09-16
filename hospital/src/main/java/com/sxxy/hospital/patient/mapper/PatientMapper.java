package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PatientMapper extends JpaRepository<Patient,Integer> {
    //查询有编号的全部病人信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "select * from patient_info where patient_num is not null or patient_num != ''")
    List<Patient> findAllPatient();

    //修改病人信息
    @Transactional()
    @Modifying
    @Query(nativeQuery = true,value = "update patient_info  set patient_leaveDate=:patientLeaveDate,patient_illness_num=:patientIllnessNum,patient_nurse_num=:patientNurseNum where patient_num =:patientNum")
    int PatientUpdate(@Param("patientLeaveDate")String patientLeaveDate,@Param("patientIllnessNum")String patientIllnessNum,@Param("patientNurseNum")String patientNurseNum,@Param("patientNum")String patientNum);

    //查询网上挂号的用户
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "select * from patient_info where patient_num is null or patient_num != ''")
    List<Patient> findAllRegister();

    //查找全部的病人
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "select count(*) from patient_info ")
    int queryAllNum();
}
