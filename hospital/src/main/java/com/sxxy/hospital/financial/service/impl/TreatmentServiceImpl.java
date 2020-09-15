package com.sxxy.hospital.financial.service.impl;

import com.sxxy.hospital.financial.mapper.StatementsMapper;
import com.sxxy.hospital.financial.mapper.TreatmentMapper;
import com.sxxy.hospital.financial.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class TreatmentServiceImpl implements TreatmentService {
    @Autowired
    private TreatmentMapper tm;
    @Autowired
    private StatementsMapper sm;

    /**
     * 定时任务，每天23点对当天的收入进行一个数据整理
     */

    @Override
    @Scheduled(cron = "0 0 23 * * ?")
    public void Treatment() {
        //格式化时间
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        String time = format.format(new Date());
        System.out.println(time);
        //查询当天病人的资费信息
        List<Map> list = tm.Treatment(time);
        System.out.println(list);
        for (Map m :list) {
            sm.add((String) m.get("bill_num"),null,"病人","医药费",m.get("bill_drug")+""+m.get("bill_hospitalization")+""+m.get("bill_inspect"),time,1,(Double) m.get("bill_countcost"));
            System.out.println(m);
        }


    }
}
