package com.sxxy.hospital.personnel.service;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OtherService {

    //删除员工
    int deleteOtherByOtherNum(List<String> delNum);

    //修改护士现状
    int editOtherNowState(String otherState, List<String> editNum);
}
