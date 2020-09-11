package com.sxxy.hospital.personnel.entity;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Entity
@Table(name = "dept")
public class Dept {
    //id，自增
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    //部门编号
    @Column(name = "dept_num")
    String deptNum;
    //部门名称
    @Column(name = "dept_name")
    String deptName;
    //登录密码
    @Column(name = "dept_password")
    String deptPassword;

    public Dept() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptNum() {
        return deptNum;
    }

    public void setDeptNum(String deptNum) {
        this.deptNum = deptNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptPassword() {
        return deptPassword;
    }

    public void setDeptPassword(String deptPassword) {
        this.deptPassword = deptPassword;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", deptNum='" + deptNum + '\'' +
                ", deptName='" + deptName + '\'' +
                ", deptPassword='" + deptPassword + '\'' +
                '}';
    }
}
