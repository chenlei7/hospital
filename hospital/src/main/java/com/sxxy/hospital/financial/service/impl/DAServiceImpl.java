package com.sxxy.hospital.financial.service.impl;

import com.sxxy.hospital.financial.mapper.DAMapper;
import com.sxxy.hospital.financial.mapper.StatementsMapper;
import com.sxxy.hospital.financial.service.DAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 主页数据统计
 */
@Service
public class DAServiceImpl implements DAService {

    @Autowired
    StatementsMapper statementsMapper;
    @Autowired
    DAMapper daMapper;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *每天1点统计昨天收入支出情况
     * @return
     */
//    @Scheduled(fixedDelay = 1000*60*60)
    @Scheduled(cron = "0 2 1 * * ?")
    public void add() {
        //获取昨天的时间
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-24);
        //格式化时间
        String date = format.format(calendar.getTime());
        //得到当天的所有支出
        double pay= statementsMapper.findPayByDate(date);
        //得到当天的所有收入
        double revenue=statementsMapper.findRevenueByDate(date);
        //计算当天的收入情况
        double total=revenue-pay;
        //将当天的收入情况放入统计表中
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
