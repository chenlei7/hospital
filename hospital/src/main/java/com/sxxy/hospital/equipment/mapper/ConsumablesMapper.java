package com.sxxy.hospital.equipment.mapper;

import com.sxxy.hospital.equipment.entity.Consumables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ConsumablesMapper extends JpaRepository<Consumables,Object> {
    //采购药材
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update consumables set consumables_number=:consumablesNumber+consumables_number  where  consumables_num in (:editNum) ")
    int addConsumablesNumber(@Param("consumablesNumber") int consumablesNumber, @Param("editNum") List<String> editNum);
}
