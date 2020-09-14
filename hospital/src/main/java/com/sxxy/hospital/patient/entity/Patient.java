package com.sxxy.hospital.patient.entity;

//病人信息实体类
import javax.persistence.*;

@Entity
@Table(name = "patient_info")
public class Patient {
    //id，自增
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    //病人编号
    @Column(name = "patient_num")
    String patientNum;
    //名字
    @Column(name = "patient_name")
    String patientName;
    //年龄
    @Column(name = "patient_age")
    Integer patientAge;
    //地址
    @Column(name = "patient_address")
    String patientAddress;
   //来看病日期
    @Column(name = "patient_comeDate")
    String patientComeDate;
    //电话
    @Column(name = "patient_phone")
    String patientPhone;
    //离开时间
    @Column(name = "patient_leaveDate")
    String patientLeaveDate;
    //病情编号
    @Column(name = "patient_illness_num")
    String patientIllnessNum;
    //主治医师编号
    @Column(name = "patient_doctor_num")
    String patientDoctorNum;
    //账单号
    @Column(name = "patient_bill_num")
    String patientBillNum;
    //护士编号
    @Column(name = "patient_nurse_num")
    String patientNurseNum;
    //科室
    @Column(name = "patient_room_num")
    String patientRoomNum;

    public Patient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatientNum() {
        return patientNum;
    }

    public void setPatientNum(String patientNum) {
        this.patientNum = patientNum;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public String getPatientComeDate() {
        return patientComeDate;
    }

    public void setPatientComeDate(String patientComeDate) {
        this.patientComeDate = patientComeDate;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientLeaveDate() {
        return patientLeaveDate;
    }

    public void setPatientLeaveDate(String patientLeaveDate) {
        this.patientLeaveDate = patientLeaveDate;
    }

    public String getPatientIllnessNum() {
        return patientIllnessNum;
    }

    public void setPatientIllnessNum(String patientIllnessNum) {
        this.patientIllnessNum = patientIllnessNum;
    }

    public String getPatientDoctorNum() {
        return patientDoctorNum;
    }

    public void setPatientDoctorNum(String patientDoctorNum) {
        this.patientDoctorNum = patientDoctorNum;
    }

    public String getPatientBillNum() {
        return patientBillNum;
    }

    public void setPatientBillNum(String patientBillNum) {
        this.patientBillNum = patientBillNum;
    }

    public String getPatientNurseNum() {
        return patientNurseNum;
    }

    public void setPatientNurseNum(String patientNurseNum) {
        this.patientNurseNum = patientNurseNum;
    }

    public String getPatientRoomNum() {
        return patientRoomNum;
    }

    public void setPatientRoomNum(String patientRoomNum) {
        this.patientRoomNum = patientRoomNum;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", patientNum='" + patientNum + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", patientAddress='" + patientAddress + '\'' +
                ", patientComeDate='" + patientComeDate + '\'' +
                ", patientPhone='" + patientPhone + '\'' +
                ", patientLeaveDate='" + patientLeaveDate + '\'' +
                ", patientIllnessNum='" + patientIllnessNum + '\'' +
                ", patientDoctorNum='" + patientDoctorNum + '\'' +
                ", patientBillNum='" + patientBillNum + '\'' +
                ", patientNurseNum='" + patientNurseNum + '\'' +
                ", patientRoomNum='" + patientRoomNum + '\'' +
                '}';
    }
}
