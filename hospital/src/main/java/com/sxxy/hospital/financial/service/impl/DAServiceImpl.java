package com.sxxy.hospital.financial.service.impl;

import com.sxxy.hospital.financial.mapper.DAMapper;
import com.sxxy.hospital.financial.mapper.StatementsMapper;
import com.sxxy.hospital.financial.service.DAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DAServiceImpl implements DAService {

    @Autowired
    StatementsMapper statementsMapper;
    @Autowired
    DAMapper daMapper;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *
     * @return
     */
    @Scheduled(cron = "0 0 23 * * ?")
    public void add() {
        String date=format.format(new Date());
        //得到当天的所有支出
        double pay= statementsMapper.findPayByDate(date);
        //得到当天的所有收入
        double revenue=statementsMapper.findRevenueByDate(date);
        //计算当天的收入情况
        double total=revenue-pay;
        int m = daMapper.add(pay, revenue, total, date);
    }

    /**
     * 获取最新的7条数据
     * @return
     */
    @Override
    public List<Map> findMoneyByDate() {
        return daMapper.findMoneyByDate();
    }

    @Override
    public double totalMoney() {
        return daMapper.totalMoney();
    }
}
