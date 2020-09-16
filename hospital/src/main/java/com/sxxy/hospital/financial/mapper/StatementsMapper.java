package com.sxxy.hospital.financial.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    //通过id查询某条数据
    Map findById(@Param("id") int id);

    //添加财务信息
    int add(@Param("num") String num,@Param("name") String name,@Param("deptName") String deptName,@Param("type") String type,@Param("event") String event,@Param("time") String time,@Param("state") int state,@Param("money") double money);
}
