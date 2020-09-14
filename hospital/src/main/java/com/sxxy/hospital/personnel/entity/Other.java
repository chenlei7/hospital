package com.sxxy.hospital.personnel.entity;

import javax.persistence.*;

@Entity
@Table(name = "other_info")
public class Other {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "other_num")
    String otherNum;
    @Column(name = "other_name")
    String otherName;
    @Column(name = "other_age")
    int otherAge;
    @Column(name = "other_gender")
    String otherGender;
    @Column(name = "other_position")
    String otherPosition;
    @Column(name = "other_workspace")
    String otherWorkspace;
    @Column(name = "other_work_date")
    String otherWorkDate;
    @Column(name = "other_password")
    String otherPassword;
    @Column(name = "other_money")
    double otherMoney;
    @Column(name = "other_state")
    String otherState;

    public Other() {
    }

    public Other(String otherNum, String otherName, int otherAge, String otherGender, String otherPosition, String otherWorkspace, String otherWorkDate , String otherPassword, double otherMoney, String otherState) {
        this.otherNum = otherNum;
        this.otherName = otherName;
        this.otherAge = otherAge;
        this.otherGender = otherGender;
        this.otherPosition = otherPosition;
        this.otherWorkspace = otherWorkspace;
        this.otherWorkDate = otherWorkDate;
        this.otherPassword = otherPassword;
        this.otherMoney = otherMoney;
        this.otherState = otherState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOtherNum() {
        return otherNum;
    }

    public void setOtherNum(String otherNum) {
        this.otherNum = otherNum;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public int getOtherAge() {
        return otherAge;
    }

    public void setOtherAge(int otherAge) {
        this.otherAge = otherAge;
    }

    public String getOtherGender() {
        return otherGender;
    }

    public void setOtherGender(String otherGender) {
        this.otherGender = otherGender;
    }

    public String getOtherPosition() {
        return otherPosition;
    }

    public void setOtherPosition(String otherPosition) {
        this.otherPosition = otherPosition;
    }

    public String getOtherWorkspace() {
        return otherWorkspace;
    }

    public void setOtherWorkspace(String otherWorkspace) {
        this.otherWorkspace = otherWorkspace;
    }

    public String getOtherWorkDate() {
        return otherWorkDate;
    }

    public void setOtherWorkDate(String otherWorkDate) {
        this.otherWorkDate = otherWorkDate;
    }


    public String getOtherPassword() {
        return otherPassword;
    }

    public void setOtherPassword(String otherPassword) {
        this.otherPassword = otherPassword;
    }

    public double getOtherMoney() {
        return otherMoney;
    }

    public void setOtherMoney(double otherMoney) {
        this.otherMoney = otherMoney;
    }

    public String getOtherState() {
        return otherState;
    }

    public void setOtherState(String otherState) {
        this.otherState = otherState;
    }

    @Override
    public String toString() {
        return "Other{" +
                "id=" + id +
                ", otherNum='" + otherNum + '\'' +
                ", otherName='" + otherName + '\'' +
                ", otherAge=" + otherAge +
                ", otherGender='" + otherGender + '\'' +
                ", otherPosition='" + otherPosition + '\'' +
                ", otherWorkspace='" + otherWorkspace + '\'' +
                ", otherWorkDate='" + otherWorkDate + '\'' +
                ", otherPassword='" + otherPassword + '\'' +
                ", otherMoney=" + otherMoney +
                ", otherState='" + otherState + '\'' +
                '}';
    }
}
