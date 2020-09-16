package com.sxxy.hospital.equipment.mapper;

import com.sxxy.hospital.equipment.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMapper extends JpaRepository<Stock,Object> {
}
