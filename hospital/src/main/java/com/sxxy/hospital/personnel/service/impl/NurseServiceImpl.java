package com.sxxy.hospital.personnel.service.impl;

import com.sxxy.hospital.personnel.entity.Nurse;
import com.sxxy.hospital.personnel.mapper.NurseMapper;
import com.sxxy.hospital.personnel.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NurseServiceImpl implements NurseService {
    @Autowired
    NurseMapper nurseMapper;

    //增加护士
    @Override
    public Nurse addNurse(Nurse nurse) {
        return nurseMapper.save(nurse);
    }
}
