package com.sxxy.hospital.personnel.mapper;

import com.sxxy.hospital.personnel.entity.Dept;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptMapper extends JpaRepository<Dept,String> {
    //部门登录
    Dept findByDeptNum(String deptNum);
}
