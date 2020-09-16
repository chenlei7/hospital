package com.sxxy.hospital.equipment.service.impl;

import com.sxxy.hospital.equipment.entity.Consumables;
import com.sxxy.hospital.equipment.mapper.ConsumablesMapper;
import com.sxxy.hospital.equipment.service.ConsumablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumablesServiceImpl implements ConsumablesService {
    @Autowired
    ConsumablesMapper consumablesMapper;
    //增加药材
    @Override
    public Consumables addConsumables(Consumables consumables) {
        return consumablesMapper.save(consumables);
    }

    @Override
    public int addConsumablesNumber(int consumablesNumber, List<String> editNum) {
        return consumablesMapper.addConsumablesNumber(consumablesNumber,editNum);
    }

    @Override
    public int addHistory(List<String> editNum) {
        return consumablesMapper.addHistroy(editNum);
    }

    @Override
    public int addHistoryNumber(int consumablesNumber, List<String> editNum) {
        return consumablesMapper.addHistoryNumber(consumablesNumber,editNum);
    }

    @Override
    public int addHistoryPrice(int consumablesNumber, List<String> editNum) {
        return consumablesMapper.addHistoryPrice(consumablesNumber,editNum);
    }
}
