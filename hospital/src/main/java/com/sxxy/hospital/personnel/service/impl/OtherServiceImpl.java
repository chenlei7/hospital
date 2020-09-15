package com.sxxy.hospital.personnel.service.impl;

import com.sxxy.hospital.personnel.entity.Other;
import com.sxxy.hospital.personnel.mapper.OtherMapper;
import com.sxxy.hospital.personnel.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherServiceImpl implements OtherService {
    @Autowired
    OtherMapper otherMapper;

    //增加员工
    @Override
    public Other addOther(Other other) {
        return otherMapper.save(other);
    }

    //编辑员工信息
    @Override
    public int updateOther(String otherPosition, String otherWorkspace, String otherWorkDate, String otherPassword,double otherMoney, String otherNum) {
        return otherMapper.updateNurse(otherPosition,otherWorkspace,otherWorkDate,otherPassword,otherMoney,otherNum);
    }

    //删除员工
    @Override
    public int deleteOtherByOtherNum(List<String> delNum) {
        return otherMapper.deleteOtherByOtherNum(delNum);
    }

    //修改员工现状
    @Override
    public int editOtherNowState(String otherState, List<String> editNum) {
        return otherMapper.editNurseNowState(otherState,editNum);
    }
}
