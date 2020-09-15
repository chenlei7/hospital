package com.sxxy.hospital.equipment.service.impl;

import com.sxxy.hospital.equipment.entity.Equipment;
import com.sxxy.hospital.equipment.mapper.EquipmentMapper;
import com.sxxy.hospital.equipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    EquipmentMapper equipmentMapper;
    @Override
    public int editequipmentNowState(String equipmentState, List<String> editNum) {
        return equipmentMapper.editequipmentNowState(equipmentState,editNum);
    }

    //增加器材
    @Override
    public Equipment addEquipment(Equipment equipment) {
        return equipmentMapper.save(equipment);
    }
}
