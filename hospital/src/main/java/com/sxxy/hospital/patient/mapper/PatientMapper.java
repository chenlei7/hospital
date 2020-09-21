package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//病人
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
    @Query(nativeQuery = true,value = "select * from patient_info where patient_num is null or patient_num = ''")
    List<Patient> findAllRegister();


    //确认挂号信息,根据ID去修改病人信息
    @Transactional()
    @Modifying
    @Query(nativeQuery = true,value = "update patient_info  set patient_num=:patientNums,patient_doctor_num=:patientDoctorNum,patient_bill_num=:patientBillNum,patient_room_num=:patientRoomNum where id =:patientId")
    int registerUpdate(@Param("patientId")String patientId, @Param("patientNums")String patientNums, @Param("patientBillNum")String patientBillNum,@Param("patientRoomNum")String patientRoomNum, @Param("patientDoctorNum")String patientDoctorNum);

    //根据id查找病人
    @Transactional()
    @Modifying
    @Query(nativeQuery = true,value = "select * from patient_info where id=:id")
    List<Patient> findOnePatient(@Param("id")Integer id);

    //根据查用户明和电话号码找病人
    @Transactional()
    @Modifying
    @Query(nativeQuery = true,value = "select * from patient_info where patient_name=:patientName and patient_phone=:patientPhone")
    List<Patient> findRegister(@Param("patientName")String patientName,@Param("patientPhone")String patientPhone);
}
