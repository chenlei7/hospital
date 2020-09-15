package com.sxxy.hospital.personnel.service;

import com.sxxy.hospital.personnel.entity.Nurse;
import com.sxxy.hospital.personnel.entity.Other;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OtherService {

    //增加员工
    Other addOther(Other other);

    //编辑员工信息
    int updateOther(String otherPosition,String otherWorkspace,String otherWorkDate,String otherPassword,double otherMoney,String otherNum);

    //删除员工
    int deleteOtherByOtherNum(List<String> delNum);

    //修改护士现状
    int editOtherNowState(String otherState, List<String> editNum);
}
