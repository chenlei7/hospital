package com.sxxy.hospital.personnel.mapper;

import com.sxxy.hospital.personnel.entity.Other;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OtherMapper extends JpaRepository<Other,Object> {



    //删除员工
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "delete from other_info  where  other_num in (:delNum) ")
    int deleteOtherByOtherNum(@Param("delNum") List<String> delNum);

    //修改员工现状
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update other_info set other_state=:otherState  where  other_num in (:editNum) ")
    int editNurseNowState(@Param("otherState")String otherState, @Param("editNum") List<String> editNum);
}
