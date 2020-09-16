package com.sxxy.hospital.equipment.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "stock_consum")
public class Stock {
    //id，自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    //药材编号
    @Column(name = "stock_num")
    String stockNum;
    //药材名称
    @Column(name = "stock_name")
    String stockName;
    //药材增加数量
    @Column(name = "stock_number")
    int stockNumber;
    //药材单价
    @Column(name = "stock_money")
    Double stockMoney;
    //药材总价
    @Column(name = "stock_price")
    Double stockPrice;
    //采购时间
    @Column(name = "stock_time")
    Date stockTime;


    public Stock() {
    }

    public Stock(String stockNum, String stockName, int stockNumber, Double stockMoney, Double stockPrice, Date stockTime) {
        this.stockNum = stockNum;
        this.stockName = stockName;
        this.stockNumber = stockNumber;
        this.stockMoney = stockMoney;
        this.stockPrice = stockPrice;
        this.stockTime = stockTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public Double getStockMoney() {
        return stockMoney;
    }

    public void setStockMoney(Double stockMoney) {
        this.stockMoney = stockMoney;
    }

    public Double getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    public Date getStockTime() {
        return stockTime;
    }

    public void setStockTime(Date stockTime) {
        this.stockTime = stockTime;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", stockNum='" + stockNum + '\'' +
                ", stockName='" + stockName + '\'' +
                ", stockNumber=" + stockNumber +
                ", stockMoney=" + stockMoney +
                ", stockPrice=" + stockPrice +
                ", stockTime=" + stockTime +
                '}';
    }
}
