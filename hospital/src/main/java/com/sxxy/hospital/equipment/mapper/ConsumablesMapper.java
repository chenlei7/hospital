package com.sxxy.hospital.equipment.mapper;

import com.sxxy.hospital.equipment.entity.Consumables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumablesMapper extends JpaRepository<Consumables,Object> {
}
