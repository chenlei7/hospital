package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.patient.entity.Bill;
import com.sxxy.hospital.personnel.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//账单
@Repository
public interface BillMapper extends JpaRepository<Bill, Object> {

    //更据Id查询
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from bill_info where id=:billId")
    List<Bill> findBillById(@Param("billId") Integer billId);

}
