package com.sxxy.hospital.equipment.service;

import com.sxxy.hospital.equipment.entity.Equipment;

import java.util.List;

public interface EquipmentService {
    //修改器材现状
    int editequipmentNowState(String equipmentState, List<String> editNum);

    //增加器材
    Equipment addEquipment(Equipment equipment);
}
