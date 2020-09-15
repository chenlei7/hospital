package com.sxxy.hospital.equipment.controller;

import com.sxxy.hospital.equipment.entity.Consumables;
import com.sxxy.hospital.equipment.mapper.ConsumablesMapper;
import com.sxxy.hospital.equipment.mapper.EquipmentMapper;
import com.sxxy.hospital.equipment.service.ConsumablesService;
import com.sxxy.hospital.equipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/consumables")
public class ConsumablesController {
    @Autowired
    ConsumablesService consumablesService;
    @Autowired
    ConsumablesMapper consumablesMapper;

    //查看所有药品
    @RequestMapping("/allconsumables")
    public String allConsumables(Model model) {
        List<Consumables> consumables = new ArrayList<>();
        consumables = consumablesMapper.findAll();
        model.addAttribute("consumabless", consumables);
        return "equipment/consumables/showconsumables";
    }

    //增加药材
    @RequestMapping("/addConsumables")
    public String addConsumables(String consumablesNum,String consumablesName,int consumablesNumber,Double consumablesPrice,String consumablesMsg,String consumablesIllness) {
        Consumables addConsumables = new Consumables(consumablesNum,consumablesName,consumablesNumber,consumablesPrice,consumablesMsg,consumablesIllness);
        if (addConsumables != null) {
            consumablesService.addConsumables(addConsumables);
            return "equipment/consumables/addconsumables";
        } else {
            return "equipment/consumables/addconsumables";
        }
    }
    //采购药材
    @RequestMapping("/addConsumablesNumber")
    public String editDoctorNowState(Integer consumablesNumber,String tag) {
        String[] strs = tag.split(",");
        System.out.println(consumablesNumber);
        for (int i = 0; i < strs.length; i++) {
            try {
                consumablesService.addConsumablesNumber(consumablesNumber,Collections.singletonList(strs[i]));
            } catch (Exception e) {
                return "personnel/error";
            }
        }
        return "equipment/consumables/showconsumables";
    }
}

