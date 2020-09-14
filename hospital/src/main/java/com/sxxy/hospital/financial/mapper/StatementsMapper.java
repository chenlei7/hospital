package com.sxxy.hospital.financial.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//@Component
@Mapper
public interface StatementsMapper {
    List<Map> findAll();
}
