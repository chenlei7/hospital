package com.sxxy.hospital.equipment.service.impl;

import com.sxxy.hospital.equipment.mapper.StockMapper;
import com.sxxy.hospital.equipment.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockMapper stockMapper;
}
