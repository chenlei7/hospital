package com.sxxy.hospital.user.entity;

import javax.persistence.*;

@Entity
@Table(name = "world_info")
public class WorldEpidemic {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    @Column
    String time;
    @Column
    String continents;
    @Column
    String provinceName;
    @Column
    String confirmedCount;
    @Column
    String currentConfirmedCount;
    @Column
    String deadCount;

    public WorldEpidemic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContinents() {
        return continents;
    }

    public void setContinents(String continents) {
        this.continents = continents;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(String confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public String getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(String currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public String getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(String deadCount) {
        this.deadCount = deadCount;
    }

    @Override
    public String toString() {
        return "WorldEpidemicEntity{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", continents='" + continents + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", confirmedCount='" + confirmedCount + '\'' +
                ", currentConfirmedCount='" + currentConfirmedCount + '\'' +
                ", deadCount='" + deadCount + '\'' +
                '}';
    }
}
