package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.personnel.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NurseMappers extends JpaRepository<Nurse,Integer> {

    //查询可派遣的护士信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "select * from nurse_info  where  nurse_state='可派遣' ")
    List<Nurse> findOneNurse();

    //修改护士现状
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update nurse_info set nurse_state=:nurseState  where  nurse_num=:editNum")
    int editNurseNowState(@Param("nurseState")String nurseState, @Param("editNum") String editNum);
}
