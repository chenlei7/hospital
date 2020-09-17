package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.patient.entity.Illness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//病情
@Repository
public interface IllnessMapper extends JpaRepository<Illness,Object> {

    //修改病情信息
    @Transactional()
    @Modifying
    @Query(nativeQuery = true,value = "update illness_info  set illness_time=:illnessTime,illness_condition=:illness_condition,illness_severity=:illnessSeverity,illness_alive=:illnessAlive where id =:illnessId")
    int illnessUpdate(@Param("illnessTime")String illnessTime, @Param("illness_condition")String illness_condition, @Param("illnessSeverity")String illnessSeverity, @Param("illnessAlive")String illnessAlive,@Param("illnessId")int illnessId);

}
