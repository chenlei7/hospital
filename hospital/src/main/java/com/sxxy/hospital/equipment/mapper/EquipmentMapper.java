package com.sxxy.hospital.equipment.mapper;

import com.sxxy.hospital.equipment.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EquipmentMapper extends JpaRepository<Equipment,Object> {
    //修改器材现状
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update equipment set equipment_state=:equipmentState  where  equipment_num in (:editNum) ")
    int editequipmentNowState(@Param("equipmentState")String equipmentState, @Param("editNum") List<String> editNum);
}
