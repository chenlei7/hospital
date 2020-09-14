package com.sxxy.hospital.patient.entity;

import javax.persistence.*;

//账单
@Entity
@Table(name = "bill_info")
public class Bill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    //账单号
    @Column(name = "bill_num")
    String billNum;
    //挂号花费
    @Column(name = "bill_registercost")
    Double billRegisterCost;
    //药品
    @Column(name = "bill_drug")
    String billDrug;
    //药品花费
    @Column(name = "bill_drugcost")
    Double billDrugCost;
    //住院
    @Column(name = "bill_hospitalization")
    String bill_hospitalization;
    //住院花费
    @Column(name = "bill_hospitalizationcost")
    Double billHospitalizationCost;
    //检查
    @Column(name = "bii_inspect")
    String biiInspect;
    //检查花费
    @Column(name = "bii_inspectcost")
    Double biiInspectCost;
    //总花费
    @Column(name = "bill_countcost")
    Double billCountCost;
    //医疗保险支出
    @Column(name = "bill_medicalInsurance")
    Double bill_medicalInsurance;
    //个人支出
    @Column(name = "bill_paid")
    Double billPaid;
    //支付方式
    @Column(name = "bill_paymentMethod")
    String billPaymentMethod;
    //时间
    @Column(name = "bill_date")
    String bill_date;

    public Bill() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public Double getBillRegisterCost() {
        return billRegisterCost;
    }

    public void setBillRegisterCost(Double billRegisterCost) {
        this.billRegisterCost = billRegisterCost;
    }

    public String getBillDrug() {
        return billDrug;
    }

    public void setBillDrug(String billDrug) {
        this.billDrug = billDrug;
    }

    public Double getBillDrugCost() {
        return billDrugCost;
    }

    public void setBillDrugCost(Double billDrugCost) {
        this.billDrugCost = billDrugCost;
    }

    public String getBill_hospitalization() {
        return bill_hospitalization;
    }

    public void setBill_hospitalization(String bill_hospitalization) {
        this.bill_hospitalization = bill_hospitalization;
    }

    public Double getBillHospitalizationCost() {
        return billHospitalizationCost;
    }

    public void setBillHospitalizationCost(Double billHospitalizationCost) {
        this.billHospitalizationCost = billHospitalizationCost;
    }

    public String getBiiInspect() {
        return biiInspect;
    }

    public void setBiiInspect(String biiInspect) {
        this.biiInspect = biiInspect;
    }

    public Double getBiiInspectCost() {
        return biiInspectCost;
    }

    public void setBiiInspectCost(Double biiInspectCost) {
        this.biiInspectCost = biiInspectCost;
    }

    public Double getBillCountCost() {
        return billCountCost;
    }

    public void setBillCountCost(Double billCountCost) {
        this.billCountCost = billCountCost;
    }

    public Double getBill_medicalInsurance() {
        return bill_medicalInsurance;
    }

    public void setBill_medicalInsurance(Double bill_medicalInsurance) {
        this.bill_medicalInsurance = bill_medicalInsurance;
    }

    public Double getBillPaid() {
        return billPaid;
    }

    public void setBillPaid(Double billPaid) {
        this.billPaid = billPaid;
    }

    public String getBillPaymentMethod() {
        return billPaymentMethod;
    }

    public void setBillPaymentMethod(String billPaymentMethod) {
        this.billPaymentMethod = billPaymentMethod;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", billNum='" + billNum + '\'' +
                ", billRegisterCost=" + billRegisterCost +
                ", billDrug='" + billDrug + '\'' +
                ", billDrugCost=" + billDrugCost +
                ", bill_hospitalization='" + bill_hospitalization + '\'' +
                ", billHospitalizationCost=" + billHospitalizationCost +
                ", biiInspect='" + biiInspect + '\'' +
                ", biiInspectCost=" + biiInspectCost +
                ", billCountCost=" + billCountCost +
                ", bill_medicalInsurance=" + bill_medicalInsurance +
                ", billPaid=" + billPaid +
                ", billPaymentMethod='" + billPaymentMethod + '\'' +
                ", bill_date='" + bill_date + '\'' +
                '}';
    }
}
