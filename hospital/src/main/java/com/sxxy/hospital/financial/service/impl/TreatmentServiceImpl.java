package com.sxxy.hospital.financial.service.impl;

import com.sxxy.hospital.financial.mapper.StatementsMapper;
import com.sxxy.hospital.financial.mapper.TreatmentMapper;
import com.sxxy.hospital.financial.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 就医部门的资金流水
 */
@Service
public class TreatmentServiceImpl implements TreatmentService {
    @Autowired
    private TreatmentMapper tm;
    @Autowired
    private StatementsMapper sm;
    //时间格式化
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 定时任务，每天1点对昨天病人信息进行一个数据整理
     */
    @Override
    @Scheduled(cron = "0 1 1 * * ?")
//    @Scheduled(fixedDelay = 1000*60*60)
    public void treatment() {
        //获取昨天的时间
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,-24);
        //格式化时间
        String time = format.format(calendar.getTime());
        System.out.println(time);
        //查询当天病人的资费信息
        List<Map> list = tm.treatment(time);
        //将资费信息添加到财务表
        for (Map m :list) {
            sm.add((String) m.get("bill_num"),"病人","用户","医药费","药品："+m.get("bill_drug")+";住院："+m.get("bill_hospitalization")+";检查："+m.get("bii_inspect"),time,1,(double) m.get("bill_countcost"));
        }

        //查询当天进货信息

    }
}
