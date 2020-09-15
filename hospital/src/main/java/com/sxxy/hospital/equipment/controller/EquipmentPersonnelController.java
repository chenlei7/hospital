package com.sxxy.hospital.equipment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equip")
public class EquipmentPersonnelController {

    //查看所有房间
    @RequestMapping("/allroom")
    public String allRoom(){
        return "equipment/room/rooms";
    }

    //增加器材
    @RequestMapping("/addequipment")
    public String addEquipment(){
        return "equipment/equipment/addequipments";
    }

    //增加药材
    @RequestMapping("/addconsumables")
    public String addConsumables(){return "equipment/consumables/addconsumables";}
}
