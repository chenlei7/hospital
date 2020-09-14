package com.sxxy.hospital.personnel.service;



import com.sxxy.hospital.personnel.entity.Nurse;

import java.util.List;

public interface NurseService {
    //增加护士
    Nurse addNurse(Nurse nurse);




    //删除护士信息
    int deleteNurseByNurseNum(List<String> delNum);

    //修改护士现状
    int editNurseNowState(String nurseState, List<String> editNum);
}
