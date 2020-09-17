package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.patient.entity.Bill;
import com.sxxy.hospital.personnel.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//账单
@Repository
public interface BillMapper extends JpaRepository<Bill,Object> {



}
