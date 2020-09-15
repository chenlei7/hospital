package com.sxxy.hospital.equipment.entity;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    //id，自增
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    //房间编号
    @Column(name = "room_num")
    String roomNum;
    //房间名称
    @Column(name = "room_name")
    String roomName;
    //房间科室
    @Column(name = "room_position")
    String roomPosition;


    public Room() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomPosition() {
        return roomPosition;
    }

    public void setRoomPosition(String roomPosition) {
        this.roomPosition = roomPosition;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNum='" + roomNum + '\'' +
                ", roomName='" + roomName + '\'' +
                ", roomPosition='" + roomPosition + '\'' +
                '}';
    }
}
