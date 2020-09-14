package com.sxxy.hospital.financial.service;

import java.util.List;
import java.util.Map;

public interface FinancialService {
    //查询所有财务信息
    List<Map> findAll();
    //用过类型查询财务信息
    List<Map> findByType(String type);
    //查询所有的支出信息
    List<Map> findByPay();
    //查询所有的收入信息
    List<Map> findByRevenue();
}
