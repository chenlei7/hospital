package com.sxxy.hospital.personnel.service;

import com.sxxy.hospital.personnel.entity.Dept;


public interface DeptService {
    //部门登录
    Dept deptLodin(String deptNum, String deptPassword );
}
