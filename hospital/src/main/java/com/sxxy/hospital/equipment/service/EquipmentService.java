package com.sxxy.hospital.equipment.service;

import java.util.List;

public interface EquipmentService {
    //修改医生现状
    int editequipmentNowState(String equipmentState, List<String> editNum);
}
