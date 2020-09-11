package com.sxxy.hospital.personnel.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor_info")
public class Doctor {
    //医生id，自增
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    //医生编号，用来做账号登录
    @Column
    String doctorNum;
    //医生年龄
    @Column
    int doctorAge;
    //医生性别
    @Column
    String doctorSex;
    //医生职位
    @Column
    String doctorPosition;
    //医生工作地点
    @Column
    String doctorWorkspace;
    //医生工作时间
    @Column
    String doctorDate;
    //医生登录密码
    @Column
    String doctorPassword;

    public Doctor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorNum() {
        return doctorNum;
    }

    public void setDoctorNum(String doctorNum) {
        this.doctorNum = doctorNum;
    }

    public int getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(int doctorAge) {
        this.doctorAge = doctorAge;
    }

    public String getDoctorSex() {
        return doctorSex;
    }

    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex;
    }

    public String getDoctorPosition() {
        return doctorPosition;
    }

    public void setDoctorPosition(String doctorPosition) {
        this.doctorPosition = doctorPosition;
    }

    public String getDoctorWorkspace() {
        return doctorWorkspace;
    }

    public void setDoctorWorkspace(String doctorWorkspace) {
        this.doctorWorkspace = doctorWorkspace;
    }

    public String getDoctorDate() {
        return doctorDate;
    }

    public void setDoctorDate(String doctorDate) {
        this.doctorDate = doctorDate;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", doctorNum='" + doctorNum + '\'' +
                ", doctorAge=" + doctorAge +
                ", doctorSex='" + doctorSex + '\'' +
                ", doctorPosition='" + doctorPosition + '\'' +
                ", doctorWorkspace='" + doctorWorkspace + '\'' +
                ", doctorDate='" + doctorDate + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                '}';
    }
}
