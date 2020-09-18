package com.sxxy.hospital.financial.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DAMapper {
    //添加一条的支出收入信息
    int add(@Param("pay") double pay,@Param("revenue") double revenue,@Param("total") double total,@Param("date") String date);

    //查询最新7条信息
    List<Map> findMoneyByDate();
    //统计总资产
    double totalMoney();
}
