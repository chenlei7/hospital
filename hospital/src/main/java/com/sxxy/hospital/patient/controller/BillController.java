package com.sxxy.hospital.patient.controller;

import com.sxxy.hospital.patient.entity.Bill;
import com.sxxy.hospital.patient.entity.Illness;
import com.sxxy.hospital.patient.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//账单与开药
@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    BillMapper billMapper;

    //查询出全部的账单信息
    @RequestMapping("/billAll")
    public String illnessAll(Model model){
        List<Bill> bills = new ArrayList<>();
        bills = billMapper.findAll();
        model.addAttribute("bills",bills);
        return "patient/bill/billAll";
    }


    //修改账单信息
    @PostMapping("/billUpdate")
    public String billUpdate(Integer billId,Model model){
        Bill bills = billMapper.findBillById(billId);
        model.addAttribute("bills",bills);
        return "patient/bill/billUpdate";
    }
}
