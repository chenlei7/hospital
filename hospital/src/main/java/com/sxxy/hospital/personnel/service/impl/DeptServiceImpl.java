package com.sxxy.hospital.personnel.service.impl;

import com.sxxy.hospital.personnel.entity.Dept;
import com.sxxy.hospital.personnel.mapper.DeptMapper;
import com.sxxy.hospital.personnel.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {
    //注入接口
    @Autowired
    DeptMapper deptMapper;
    //部门登录
    @Override
    public Dept deptLodin(String deptNum, String deptPassword) {
        return deptMapper.findByDeptNumAndDeptPassword(deptNum,deptPassword);
    }
}
