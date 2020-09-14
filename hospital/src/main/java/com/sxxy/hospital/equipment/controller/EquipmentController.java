package com.sxxy.hospital.equipment.controller;

import com.sxxy.hospital.equipment.entity.Equipment;
import com.sxxy.hospital.equipment.mapper.EquipmentMapper;
import com.sxxy.hospital.equipment.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;
    @Autowired
    EquipmentMapper equipmentMapper;

    //查看所有器材
    @RequestMapping("/equipments")
    public String allEquipment(Model model) {
        List<Equipment> equipments = new ArrayList<>();
        equipments = equipmentMapper.findAll();
        model.addAttribute("equipments", equipments);
        return "equipment/equipment/showequipments";
    }

    //修改器材现状
    @RequestMapping("/editEquipmentNowState")
    public String editEquipmentNowState(String equipmentState,String tag) {
        String[] strs = tag.split(",");
        System.out.println(equipmentState);
        for (int i = 0; i < strs.length; i++) {
            try {
                equipmentService.editequipmentNowState(equipmentState, Collections.singletonList(strs[i]));
            } catch (Exception e) {
                return "personnel/error";
            }
        }
        return "equipment/equipment/showequipments";
    }
}
