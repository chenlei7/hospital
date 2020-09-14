package com.sxxy.hospital.equipment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/equippersonnel")
public class EquipmentPersonnelController {

    //查看所有房间
    @RequestMapping("/allroom")
    public String allRoom(){
        return "equipment/room/rooms";
    }
}
