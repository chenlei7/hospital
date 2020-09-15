package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PatientMapper extends JpaRepository<Patient,Integer> {

    @Transactional()
    @Modifying
    @Query(nativeQuery = true,value = "update patient_info  set patient_leaveDate=:patientLeaveDate,patient_illness_num=:patientIllnessNum,patient_nurse_num=:patientNurseNum where patient_num =:patientNum")
    int PatientUpdate(@Param("patientLeaveDate")String patientLeaveDate,@Param("patientIllnessNum")String patientIllnessNum,@Param("patientNurseNum")String patientNurseNum,@Param("patientNum")String patientNum);

}
