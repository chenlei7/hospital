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
    @Override
    public List<Map> findAll() {
        return mapper.findAll();
    }
}
