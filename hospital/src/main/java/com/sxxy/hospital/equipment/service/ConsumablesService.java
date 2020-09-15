package com.sxxy.hospital.equipment.service;

import com.sxxy.hospital.equipment.entity.Consumables;

import java.util.List;

public interface ConsumablesService {
    //增加药材
    Consumables addConsumables(Consumables consumables);

    //采购药材
    int addConsumablesNumber(int consumablesNumber, List<String> editNum);
}
