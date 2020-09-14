package com.sxxy.hospital.patient.entity;

import javax.persistence.*;

//病情
@Entity
@Table(name = "illness_info")
public class Illness {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    //病情编号
    @Column(name = "illness_num")
    String illnessNum;
    //时间
    @Column(name = "illness_time")
    String illnessTime;
    //病况描述
    @Column(name = "illness_condition")
    String illness_condition;
    //严重程度
    @Column(name = "illness_severity")
    String illnessSeverity;
    //生还几率
    @Column(name = "illness_alive")
    String illnessAlive;

    public Illness() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIllnessNum() {
        return illnessNum;
    }

    public void setIllnessNum(String illnessNum) {
        this.illnessNum = illnessNum;
    }

    public String getIllnessTime() {
        return illnessTime;
    }

    public void setIllnessTime(String illnessTime) {
        this.illnessTime = illnessTime;
    }

    public String getIllness_condition() {
        return illness_condition;
    }

    public void setIllness_condition(String illness_condition) {
        this.illness_condition = illness_condition;
    }

    public String getIllnessSeverity() {
        return illnessSeverity;
    }

    public void setIllnessSeverity(String illnessSeverity) {
        this.illnessSeverity = illnessSeverity;
    }

    public String getIllnessAlive() {
        return illnessAlive;
    }

    public void setIllnessAlive(String illnessAlive) {
        this.illnessAlive = illnessAlive;
    }

    @Override
    public String toString() {
        return "Illness{" +
                "id=" + id +
                ", illnessNum='" + illnessNum + '\'' +
                ", illnessTime='" + illnessTime + '\'' +
                ", illness_condition='" + illness_condition + '\'' +
                ", illnessSeverity='" + illnessSeverity + '\'' +
                ", illnessAlive='" + illnessAlive + '\'' +
                '}';
    }
}
