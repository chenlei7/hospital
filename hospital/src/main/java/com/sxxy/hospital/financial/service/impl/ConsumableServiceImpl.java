package com.sxxy.hospital.financial.service.impl;

import com.sxxy.hospital.financial.mapper.StatementsMapper;
import com.sxxy.hospital.financial.mapper.TreatmentMapper;
import com.sxxy.hospital.financial.service.ConsumableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *后勤部资金流动
 */
@Service
public class ConsumableServiceImpl implements ConsumableService {
    @Autowired
    TreatmentMapper treatmentMapper;
    //财务表dao接口
    @Autowired
    StatementsMapper statementsMapper;
    //格式化时间
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 每天23点统计当天药品的进货账单
     */
//    @Scheduled(fixedDelay = 1000*60*60)
    @Scheduled(cron = "0 0 23 * * ?")
    public void consumable(){
        //获取当天时间
        String time = format.format(new Date());
        //获取当天的药品的进货账单
        List<Map> list =  treatmentMapper.consumable(time);
        //时间格式化mysql中的timestamp类型
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //添加到财务表中
        for (Map map:list){
            statementsMapper.add((String) map.get("stock_num"),(String)map.get("stock_name"),"后勤部","药品","数量："+map.get("stock_number"),format2.format(map.get("stock_time")),0,(Double)map.get("stock_price"));
        }
    }
}
