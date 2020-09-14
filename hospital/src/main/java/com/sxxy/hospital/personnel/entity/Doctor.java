package com.sxxy.hospital.personnel.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor_info")
public class Doctor {
    //id,自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //医生编号
    @Column(name = "doctor_num")
    String doctorNum;
    @Column(name = "doctor_name")
    String doctorName;
    @Column(name = "doctor_phone")
    String doctorPhone;
    @Column(name = "doctor_birthday")
    String doctorBirthday;
    @Column(name = "doctor_address")
    String doctorAddress;
    @Column(name = "doctor_email")
    String doctorEmail;
    @Column(name = "doctor_age")
    int doctorAge;
    @Column(name = "doctor_gender")
    String doctorGender;
    @Column(name = "doctor_position")
    String doctorPosition;
    @Column(name = "doctor_workspace")
    String doctorWorkspace;
    @Column(name = "doctor_work_date")
    String doctorWorkDate;
    @Column(name = "doctor_about")
    String doctorAbout;
    @Column(name = "doctor_password")
    String doctorPassword;
    @Column(name = "doctor_state")
    String doctorState;

    public Doctor() {
    }

    public Doctor(String doctorNum, String doctorName, String doctorPhone, String doctorBirthday, String doctorAddress, String doctorEmail, int doctorAge, String doctorGender, String doctorPosition, String doctorWorkspace, String doctorWorkDate, String doctorAbout, String doctorPassword,String doctorState) {
        this.doctorNum = doctorNum;
        this.doctorName = doctorName;
        this.doctorPhone = doctorPhone;
        this.doctorBirthday = doctorBirthday;
        this.doctorAddress = doctorAddress;
        this.doctorEmail = doctorEmail;
        this.doctorAge = doctorAge;
        this.doctorGender = doctorGender;
        this.doctorPosition = doctorPosition;
        this.doctorWorkspace = doctorWorkspace;
        this.doctorWorkDate = doctorWorkDate;
        this.doctorAbout = doctorAbout;
        this.doctorPassword = doctorPassword;
        this.doctorState = doctorState;
    }


    public String getDoctorState() {
        return doctorState;
    }

    public void setDoctorState(String doctorState) {
        this.doctorState = doctorState;
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

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorBirthday() {
        return doctorBirthday;
    }

    public void setDoctorBirthday(String doctorBirthday) {
        this.doctorBirthday = doctorBirthday;
    }

    public String getDoctorAddress() {
        return doctorAddress;
    }

    public void setDoctorAddress(String doctorAddress) {
        this.doctorAddress = doctorAddress;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public int getDoctorAge() {
        return doctorAge;
    }

    public void setDoctorAge(int doctorAge) {
        this.doctorAge = doctorAge;
    }

    public String getDoctorGender() {
        return doctorGender;
    }

    public void setDoctorGender(String doctorGender) {
        this.doctorGender = doctorGender;
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

    public String getDoctorWorkDate() {
        return doctorWorkDate;
    }

    public void setDoctorWorkDate(String doctorWorkDate) {
        this.doctorWorkDate = doctorWorkDate;
    }

    public String getDoctorAbout() {
        return doctorAbout;
    }

    public void setDoctorAbout(String doctorAbout) {
        this.doctorAbout = doctorAbout;
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
                ", doctorName='" + doctorName + '\'' +
                ", doctorPhone='" + doctorPhone + '\'' +
                ", doctorBirthday='" + doctorBirthday + '\'' +
                ", doctorAddress='" + doctorAddress + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorAge=" + doctorAge +
                ", doctorGender='" + doctorGender + '\'' +
                ", doctorPosition='" + doctorPosition + '\'' +
                ", doctorWorkspace='" + doctorWorkspace + '\'' +
                ", doctorWorkDate='" + doctorWorkDate + '\'' +
                ", doctorAbout='" + doctorAbout + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                ", doctorState='" + doctorState + '\'' +
                '}';
    }
}
