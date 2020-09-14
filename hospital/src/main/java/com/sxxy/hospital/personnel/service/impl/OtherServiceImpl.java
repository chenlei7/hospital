package com.sxxy.hospital.personnel.service.impl;

import com.sxxy.hospital.personnel.mapper.OtherMapper;
import com.sxxy.hospital.personnel.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherServiceImpl implements OtherService {
    @Autowired
    OtherMapper otherMapper;

    //删除员工
    @Override
    public int deleteOtherByOtherNum(List<String> delNum) {
        return otherMapper.deleteOtherByOtherNum(delNum);
    }
}
