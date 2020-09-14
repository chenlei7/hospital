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
}
