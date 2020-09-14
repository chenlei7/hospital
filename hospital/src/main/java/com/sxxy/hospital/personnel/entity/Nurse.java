package com.sxxy.hospital.personnel.entity;

import javax.persistence.*;

@Entity
@Table(name = "nurse_info")
public class Nurse {
    //id,自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "nurse_num")
    String nurseNum;
    @Column(name = "nurse_name")
    String nurseName;
    @Column(name = "nurse_phone")
    String nursePhone;
    @Column(name = "nurse_birthday")
    String nurseBirthday;
    @Column(name = "nurse_address")
    String nurseAddress;
    @Column(name = "nurse_email")
    String nurseEmail;
    @Column(name = "nurse_age")
    int nurseAge;
    @Column(name = "nurse_gender")
    String nurseGender;
    @Column(name = "nurse_position")
    String nursePosition;
    @Column(name = "nurse_workspace")
    String nurseWorkspace;
    @Column(name = "nurse_work_date")
    String nurseWorkDate;
    @Column(name = "nurse_about")
    String nurseAbout;
    @Column(name = "nurse_password")
    String nursePassword;
    @Column(name = "nurse_money")
    double nurseMoney;
    @Column(name = "nurse_state")
    String nurseState;

    public Nurse() {
    }

    public Nurse(String nurseNum, String nurseName, String nursePhone, String nurseBirthday, String nurseAddress, String nurseEmail, int nurseAge, String nurseGender, String nursePosition, String nurseWorkspace, String nurseWorkDate, String nurseAbout, String nursePassword, double nurseMoney, String nurseState) {
        this.nurseNum = nurseNum;
        this.nurseName = nurseName;
        this.nursePhone = nursePhone;
        this.nurseBirthday = nurseBirthday;
        this.nurseAddress = nurseAddress;
        this.nurseEmail = nurseEmail;
        this.nurseAge = nurseAge;
        this.nurseGender = nurseGender;
        this.nursePosition = nursePosition;
        this.nurseWorkspace = nurseWorkspace;
        this.nurseWorkDate = nurseWorkDate;
        this.nurseAbout = nurseAbout;
        this.nursePassword = nursePassword;
        this.nurseMoney = nurseMoney;
        this.nurseState = nurseState;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNurseNum() {
        return nurseNum;
    }

    public void setNurseNum(String nurseNum) {
        this.nurseNum = nurseNum;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }

    public String getNursePhone() {
        return nursePhone;
    }

    public void setNursePhone(String nursePhone) {
        this.nursePhone = nursePhone;
    }

    public String getNurseBirthday() {
        return nurseBirthday;
    }

    public void setNurseBirthday(String nurseBirthday) {
        this.nurseBirthday = nurseBirthday;
    }

    public String getNurseAddress() {
        return nurseAddress;
    }

    public void setNurseAddress(String nurseAddress) {
        this.nurseAddress = nurseAddress;
    }

    public String getNurseEmail() {
        return nurseEmail;
    }

    public void setNurseEmail(String nurseEmail) {
        this.nurseEmail = nurseEmail;
    }

    public int getNurseAge() {
        return nurseAge;
    }

    public void setNurseAge(int nurseAge) {
        this.nurseAge = nurseAge;
    }

    public String getNurseGender() {
        return nurseGender;
    }

    public void setNurseGender(String nurseGender) {
        this.nurseGender = nurseGender;
    }

    public String getNursePosition() {
        return nursePosition;
    }

    public void setNursePosition(String nursePosition) {
        this.nursePosition = nursePosition;
    }

    public String getNurseWorkspace() {
        return nurseWorkspace;
    }

    public void setNurseWorkspace(String nurseWorkspace) {
        this.nurseWorkspace = nurseWorkspace;
    }

    public String getNurseWorkDate() {
        return nurseWorkDate;
    }

    public void setNurseWorkDate(String nurseWorkDate) {
        this.nurseWorkDate = nurseWorkDate;
    }

    public String getNurseAbout() {
        return nurseAbout;
    }

    public void setNurseAbout(String nurseAbout) {
        this.nurseAbout = nurseAbout;
    }

    public String getNursePassword() {
        return nursePassword;
    }

    public void setNursePassword(String nursePassword) {
        this.nursePassword = nursePassword;
    }

    public double getNurseMoney() {
        return nurseMoney;
    }

    public void setNurseMoney(double nurseMoney) {
        this.nurseMoney = nurseMoney;
    }

    public String getNurseState() {
        return nurseState;
    }

    public void setNurseState(String nurseState) {
        this.nurseState = nurseState;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "id=" + id +
                ", nurseNum='" + nurseNum + '\'' +
                ", nurseName='" + nurseName + '\'' +
                ", nursePhone='" + nursePhone + '\'' +
                ", nurseBirthday='" + nurseBirthday + '\'' +
                ", nurseAddress='" + nurseAddress + '\'' +
                ", nurseEmail='" + nurseEmail + '\'' +
                ", nurseAge=" + nurseAge +
                ", nurseGender='" + nurseGender + '\'' +
                ", nursePosition='" + nursePosition + '\'' +
                ", nurseWorkspace='" + nurseWorkspace + '\'' +
                ", nurseWorkDate='" + nurseWorkDate + '\'' +
                ", nurseAbout='" + nurseAbout + '\'' +
                ", nursePassword='" + nursePassword + '\'' +
                ", nurseMoney=" + nurseMoney +
                ", nurseState='" + nurseState + '\'' +
                '}';
    }
}
