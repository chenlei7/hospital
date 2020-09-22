package com.sxxy.hospital.equipment.controller;

import com.sxxy.hospital.equipment.entity.Room;
import com.sxxy.hospital.equipment.mapper.RoomMapper;
import com.sxxy.hospital.equipment.service.RoomService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomService roomService;
    @Autowired
    RoomMapper roomMapper;


    //查看所有房间
    @RequestMapping("/rooms")
    @RequiresRoles(value={"admin","other","doctor"},logical = Logical.OR)
    public String allRoom(Model model) {
        List<Room> rooms = new ArrayList<>();
        rooms = roomMapper.findAll();
        model.addAttribute("rooms", rooms);
        return "equipment/room/rooms";
    }


}
