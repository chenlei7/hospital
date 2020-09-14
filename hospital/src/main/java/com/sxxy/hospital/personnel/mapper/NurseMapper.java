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




    //修改护士现状
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update nurse_info set nurse_state=:nurseState  where  nurse_num in (:editNum) ")
    int editNurseNowState(@Param("nurseState")String nurseState, @Param("editNum") List<String> editNum);
}
