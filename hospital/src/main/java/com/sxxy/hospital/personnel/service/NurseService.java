package com.sxxy.hospital.personnel.service;



import com.sxxy.hospital.personnel.entity.Nurse;

import java.util.List;

public interface NurseService {
    //增加护士
    Nurse addNurse(Nurse nurse);

    //编辑护士信息
    int updateNurse(String nursePhone, String nurseAddress, String nurseEmail, String nursePosition, String nurseWorkspace, String nurseWorkDate, String nurseAbout,String nursePassword,double nurseMoney,String nurseNum);

    //删除护士信息
    int deleteNurseByNurseNum(List<String> delNum);

    //修改护士现状
    int editNurseNowState(String nurseState, List<String> editNum);

    //查询某个护士
    Nurse findByNurseNum(String num);

}
