package com.sxxy.hospital.financial.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TreatmentMapper {
    //查询某天的病人资费
    List<Map> Treatment(@Param("time") String time);
}
