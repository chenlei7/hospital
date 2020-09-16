package com.sxxy.hospital.equipment.service;

import com.sxxy.hospital.equipment.entity.Consumables;

import java.util.List;

public interface ConsumablesService {
    //增加药材
    Consumables addConsumables(Consumables consumables);

    //采购药材
    int addConsumablesNumber(int consumablesNumber, List<String> editNum);

    //采购记录
    int addHistory(List<String> editNum);

    //采购数量
    int addHistoryNumber(int consumablesNumber, List<String> editNum);

    //计算采购总价
    int addHistoryPrice(int consumablesNumber, List<String> editNum);
}
