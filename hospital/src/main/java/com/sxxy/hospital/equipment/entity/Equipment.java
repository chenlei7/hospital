package com.sxxy.hospital.equipment.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "equipment")
public class Equipment {
    //id，自增
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    //器材编号
    @Column(name = "equipment_num")
    String equipmentNum;
    //器材名称
    @Column(name = "equipment_name")
    String equipmentName;
    //器材状态
    @Column(name = "equipment_state")
    String equipmentState;
    //器材价格
    @Column(name = "equipment_price")
    Double equipmentPrice;
    @Column(name = "equipment_site")
    String equipmentSite;
    @Column(name = "equipment_time")
    Date equipmentTime;


    public Equipment() {
    }

    public Equipment(String equipmentNum, String equipmentName, String equipmentState, Double equipmentPrice, String equipmentSite, Date equipmentTime) {
        this.equipmentNum = equipmentNum;
        this.equipmentName = equipmentName;
        this.equipmentState = equipmentState;
        this.equipmentPrice = equipmentPrice;
        this.equipmentSite = equipmentSite;
        this.equipmentTime = equipmentTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipmentNum() {
        return equipmentNum;
    }

    public void setEquipmentNum(String equipmentNum) {
        this.equipmentNum = equipmentNum;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentState() {
        return equipmentState;
    }

    public void setEquipmentState(String equipmentState) {
        this.equipmentState = equipmentState;
    }

    public Double getEquipmentPrice() {
        return equipmentPrice;
    }

    public void setEquipmentPrice(Double equipmentPrice) {
        this.equipmentPrice = equipmentPrice;
    }

    public String getEquipmentSite() {
        return equipmentSite;
    }

    public void setEquipmentSite(String equipmentSite) {
        this.equipmentSite = equipmentSite;
    }

    public Date getEquipmentTime() {
        return equipmentTime;
    }

    public void setEquipmentTime(Date equipmentTime) {
        this.equipmentTime = equipmentTime;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", equipmentNum='" + equipmentNum + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentState='" + equipmentState + '\'' +
                ", equipmentPrice=" + equipmentPrice +
                ", equipmentSite='" + equipmentSite + '\'' +
                ", equipmentTime=" + equipmentTime +
                '}';
    }
}
