package com.sxxy.hospital.financial.service.impl;

import com.sxxy.hospital.financial.mapper.StatementsMapper;
import com.sxxy.hospital.financial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 财务表的操作
 */
@Service
public class FinancialServiceImpl implements FinancialService {
   @Autowired
   StatementsMapper mapper;
    //查询所有财务信息
    @Override
    public List<Map> findAll() {
        return mapper.findAll();
    }

    //用过类型查询财务信息
    @Override
    public List<Map> findByType(String type) {
        return mapper.findByType(type);
    }

    @Override
    public Map findById(int id) {
        return mapper.findById(id);
    }

    @Override
    public int add(String statementNum,String statementName,String statementDeptName,String statementType,String statementEvent,String statementTime,int statementState,double statementMoney) {
        return mapper.add(statementNum, statementName, statementDeptName, statementType, statementEvent, statementTime, statementState, statementMoney);
    }
}
