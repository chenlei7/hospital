package com.sxxy.hospital.financial.service;

import java.util.List;
import java.util.Map;

/**
 * 数据统计
 */
public interface DAService {

    //统计近七天财务情况
    List<Map> findMoneyByDate();
    //统计总资产
    double totalMoney();
}
