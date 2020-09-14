package com.sxxy.hospital.personnel.service.impl;

import com.sxxy.hospital.personnel.entity.Nurse;
import com.sxxy.hospital.personnel.mapper.NurseMapper;
import com.sxxy.hospital.personnel.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseServiceImpl implements NurseService {
    @Autowired
    NurseMapper nurseMapper;

    //增加护士
    @Override
    public Nurse addNurse(Nurse nurse) {
        return nurseMapper.save(nurse);
    }

    //编辑护士信息
    @Override
    public int updateNurse(String nursePhone, String nurseAddress, String nurseEmail, String nursePosition, String nurseWorkspace, String nurseWorkDate, String nurseAbout, String nursePassword, double nurseMoney, String nurseNum) {
        return nurseMapper.updateNurse(nursePhone,nurseAddress,nurseEmail,nursePosition,nurseWorkspace,nurseWorkDate,nurseAbout,nursePassword,nurseMoney,nurseNum);
    }


    //删除护士信息
    @Override
    public int deleteNurseByNurseNum(List<String> delNum) {
        return nurseMapper.deleteNurseByNurseNum(delNum);
    }


    //修改护士现状
    @Override
    public int editNurseNowState(String nurseState, List<String> editNum) {
        return nurseMapper.editNurseNowState(nurseState, editNum);
    }
}
