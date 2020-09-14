package com.sxxy.hospital.financial.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//@Component
@Mapper
public interface StatementsMapper {
    //查询所有财务信息
    List<Map> findAll();
    //用过类型查询财务信息
    List<Map> findByType(@Param("type") String type);
    //查询所有的支出信息
    List<Map> findByPay();
    //查询所有的收入信息
    List<Map> findByRevenue();
}
