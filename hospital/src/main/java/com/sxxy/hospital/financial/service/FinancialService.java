package com.sxxy.hospital.financial.service;

import java.util.List;
import java.util.Map;

public interface FinancialService {
    //查询所有财务信息
    List<Map> findAll();

    //用过类型查询财务信息
    List<Map> findByType(String type);

    //id查询信息
    Map findById(int id);

    int add(String statementNum,String statementName,String statementDeptName,String statementType,String statementEvent,String statementTime,int statementState,double statementMoney);
}
