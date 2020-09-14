package com.sxxy.hospital.equipment.entity;

import javax.persistence.*;

@Entity
@Table(name = "consumables")
public class Consumables {
    //id，自增
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    //药品编号
    @Column(name = "consumables_num")
    String consumablesNum;
    //药品名称
    @Column(name = "consumables_name")
    String consumablesName;
    //药品数量
    @Column(name = "consumables_number")
    int consumablesNumber;
    //药品价格
    @Column(name = "consumables_price")
    Double consumablesPrice;
    //药品作用
    @Column(name = "consumables_msg")
    String consumablesMsg;
    //药品治疗病症
    @Column(name = "consumables_illness")
    String consumablesIllness;

    public Consumables() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConsumablesNum() {
        return consumablesNum;
    }

    public void setConsumablesNum(String consumablesNum) {
        this.consumablesNum = consumablesNum;
    }

    public String getConsumablesName() {
        return consumablesName;
    }

    public void setConsumablesName(String consumablesName) {
        this.consumablesName = consumablesName;
    }

    public int getConsumablesNumber() {
        return consumablesNumber;
    }

    public void setConsumablesNumber(int consumablesNumber) {
        this.consumablesNumber = consumablesNumber;
    }

    public Double getConsumablesPrice() {
        return consumablesPrice;
    }

    public void setConsumablesPrice(Double consumablesPrice) {
        this.consumablesPrice = consumablesPrice;
    }

    public String getConsumablesMsg() {
        return consumablesMsg;
    }

    public void setConsumablesMsg(String consumablesMsg) {
        this.consumablesMsg = consumablesMsg;
    }

    public String getConsumablesIllness() {
        return consumablesIllness;
    }

    public void setConsumablesIllness(String consumablesIllness) {
        this.consumablesIllness = consumablesIllness;
    }

    @Override
    public String toString() {
        return "Consumables{" +
                "id=" + id +
                ", consumablesNum='" + consumablesNum + '\'' +
                ", consumablesName='" + consumablesName + '\'' +
                ", consumablesNumber=" + consumablesNumber +
                ", consumablesPrice=" + consumablesPrice +
                ", consumablesMsg='" + consumablesMsg + '\'' +
                ", consumablesIllness='" + consumablesIllness + '\'' +
                '}';
    }
}
