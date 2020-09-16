package com.sxxy.hospital.user.entity;

import javax.persistence.*;

@Entity
@Table(name = "chinese_info")
public class ChineseEpidemic {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer code;
    @Column
    String time;
    @Column
    String provinceShortName;
    @Column
    String currentConfirmedCount;
    @Column
    String cityName;
    @Column
    String confirmCount;
    @Column
    String curedCount;
    @Column
    String deadCount;

    public ChineseEpidemic() {
    }


    public String getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(String currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getConfirmCount() {
        return confirmCount;
    }

    public void setConfirmCount(String confirmCount) {
        this.confirmCount = confirmCount;
    }

    public String getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(String curedCount) {
        this.curedCount = curedCount;
    }

    public String getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(String deadCount) {
        this.deadCount = deadCount;
    }

    @Override
    public String toString() {
        return "ChineseEpidemic{" +
                "code=" + code +
                ", time='" + time + '\'' +
                ", provinceShortName='" + provinceShortName + '\'' +
                ", currentConfirmedCount='" + currentConfirmedCount + '\'' +
                ", cityName='" + cityName + '\'' +
                ", confirmCount='" + confirmCount + '\'' +
                ", curedCount='" + curedCount + '\'' +
                ", deadCount='" + deadCount + '\'' +
                '}';
    }
}
