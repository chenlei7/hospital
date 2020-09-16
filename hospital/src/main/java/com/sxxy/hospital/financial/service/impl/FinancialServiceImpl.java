package com.sxxy.hospital.financial.service.impl;

import com.sxxy.hospital.financial.mapper.StatementsMapper;
import com.sxxy.hospital.financial.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    //查询所有的支出信息
    @Override
    public List<Map> findByPay() {
        return mapper.findByPay();
    }

    //查询所有的收入信息
    @Override
    public List<Map> findByRevenue() {
        return mapper.findByRevenue();
    }

    @Override
    public Map findById(int id) {
        return mapper.findById(id);
    }
}
