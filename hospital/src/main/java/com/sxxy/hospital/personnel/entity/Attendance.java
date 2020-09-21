package com.sxxy.hospital.personnel.entity;

import javax.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {
    //id，自增
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    //部门编号
    @Column(name = "attendance_num")
    String attendanceNum;
    //部门名称
    @Column(name = "attendance_name")
    String attendanceName;
    //登录密码
    @Column(name = "attendance_date")
    String attendanceDate;

    public Attendance() {
    }

    public Attendance(String attendanceNum, String attendanceName, String attendanceDate) {
        this.attendanceNum = attendanceNum;
        this.attendanceName = attendanceName;
        this.attendanceDate = attendanceDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttendanceNum() {
        return attendanceNum;
    }

    public void setAttendanceNum(String attendanceNum) {
        this.attendanceNum = attendanceNum;
    }

    public String getAttendanceName() {
        return attendanceName;
    }

    public void setAttendanceName(String attendanceName) {
        this.attendanceName = attendanceName;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", attendanceNum='" + attendanceNum + '\'' +
                ", attendanceName='" + attendanceName + '\'' +
                ", attendanceDate='" + attendanceDate + '\'' +
                '}';
    }
}
