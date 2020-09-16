package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.equipment.entity.Room;
import com.sxxy.hospital.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//房间
@Repository
public interface RoomMappers extends JpaRepository<Room,Object>{
    //根据房间名字查找房间编号
    @Transactional()
    @Modifying
    @Query(nativeQuery = true,value = "select * from room where room_name=:roomName")
    List<Room> findRoomByName(@Param("roomName")String roomName);


}
