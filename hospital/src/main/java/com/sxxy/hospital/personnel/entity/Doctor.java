package com.sxxy.hospital.personnel.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor_info")
public class Doctor {
    //医生id，自增
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    //医生编号
    @Column
    String doctorNum;

}
