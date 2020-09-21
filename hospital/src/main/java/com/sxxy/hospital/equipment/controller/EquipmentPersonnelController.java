package com.sxxy.hospital.equipment.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equip")
public class EquipmentPersonnelController {

    //查看所有房间
    @RequestMapping("/allroom")
    @RequiresRoles(value={"admin","other","doctor"},logical = Logical.OR)
    public String allRoom(){
        return "equipment/room/rooms";
    }

    //增加器材
    @RequestMapping("/addequipment")
    @RequiresRoles(value={"admin","other"},logical = Logical.OR)
    public String addEquipment(){
        return "equipment/equipment/addequipments";
    }

    //增加药材
    @RequestMapping("/addconsumables")
    @RequiresRoles(value={"admin","other"},logical = Logical.OR)
    public String addConsumables(){return "equipment/consumables/addconsumables";}
}
