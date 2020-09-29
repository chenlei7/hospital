package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.patient.entity.Bill;
import com.sxxy.hospital.patient.entity.Illness;
import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.BillMapper;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

//账单与开药
@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    BillMapper billMapper;

    //查询出全部的账单信息
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @RequestMapping("/billAll")
    public String illnessAll(Model model){
        List<Bill> bills = new ArrayList<>();
        bills = billMapper.findAll();
        model.addAttribute("bills",bills);
        return "patient/bill/billAll";
    }


    //修改账单信息
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @ResponseBody
    @RequestMapping("/billUpdate")
    public String billUpdate(Integer billId, HttpSession session){
        try {
            List<Bill> bills = billMapper.findBillById(billId);
            session.setAttribute("bills",bills);
        }catch (Exception e){
            return "0";
        }
        return "1";
    }

    //真正的去执行修改账单的方法
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @RequestMapping("/billUpdates")
    public String billUpdates(Bill bill){
        try {
            //计算总的花费
            Double count = bill.getBillRegisterCost()+bill.getBillDrugCost()+bill.getBillHospitalizationCost()+bill.getBiiInspectCost();
            bill.setBillCountCost(count);
            billMapper.save(bill);
        }catch (Exception e){
            return "patient/error";
        }
        return "patient/doctor/doctorSuccess1";
    }

    //判断账单号是否存在
    @RequestMapping("/queryNum1")
    @RequiresRoles(value={"admin","doctor"},logical = Logical.OR)
    @ResponseBody
    public String queryNum1(String patientBillNum) {
        List<Bill> patientNum1 = billMapper.findBillByNum(patientBillNum);
        System.out.println("!!!"+patientNum1);
        if (patientNum1.size()>=1){
            return "存在";
        }else {
            return "编号不存在";
        }
    }
}
