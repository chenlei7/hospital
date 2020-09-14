package com.sxxy.hospital.personnel.mapper;

import com.sxxy.hospital.personnel.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NurseMapper extends JpaRepository<Nurse,Object> {
    //编辑护士信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update nurse_info  set nurse_phone=:nursePhone,nurse_address=:nurseAddress,nurse_email=:nurseEmail,nurse_position=:nursePosition,nurse_workspace=:nurseWorkspace,nurse_work_date=:nurseWorkDate,nurse_about=:nurseAbout,nurse_password=:nursePassword,nurse_money=:nurseMoney where nurse_num =:nurseNum")
    int updateNurse(@Param("nursePhone")String nursePhone,@Param("nurseAddress")String nurseAddress,@Param("nurseEmail")String nurseEmail,
                     @Param("nursePosition")String nursePosition,@Param("nurseWorkspace")String nurseWorkspace,@Param("nurseWorkDate")String nurseWorkDate,
                     @Param("nurseAbout")String nurseAbout,@Param("nursePassword")String nursePassword,@Param("nurseMoney")double nurseMoney,@Param("nurseNum")String nurseNum);

    //删除护士信息
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "delete  from nurse_info  where  nurse_num in (:delNum) ")
    int deleteNurseByNurseNum(@Param("delNum") List<String> delNum);

    //修改护士现状
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update nurse_info set nurse_state=:nurseState  where  nurse_num in (:editNum) ")
    int editNurseNowState(@Param("nurseState")String nurseState, @Param("editNum") List<String> editNum);
}
