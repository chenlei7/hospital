package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.patient.entity.Bill;
import com.sxxy.hospital.patient.entity.Patient;
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

    //更据账单编号编号去查找
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "select * from bill_info where bill_num=:BillNum")
    List<Bill> findBillByNum(@Param("BillNum")String BillNum);

}
