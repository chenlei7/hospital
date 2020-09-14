package com.sxxy.hospital.equipment.entity;

import javax.persistence.*;

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


    public Equipment() {
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

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", equipmentNum='" + equipmentNum + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentState='" + equipmentState + '\'' +
                ", equipmentPrice=" + equipmentPrice +
                ", equipmentSite='" + equipmentSite + '\'' +
                '}';
    }
}
