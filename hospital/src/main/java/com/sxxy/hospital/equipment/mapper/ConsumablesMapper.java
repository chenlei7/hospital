package com.sxxy.hospital.equipment.mapper;

import com.sxxy.hospital.equipment.entity.Consumables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ConsumablesMapper extends JpaRepository<Consumables,Object> {
    //采购药材
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update consumables set consumables_number=:consumablesNumber + consumables_number  where  consumables_num in (:editNum) ")
    int addConsumablesNumber(@Param("consumablesNumber") int consumablesNumber, @Param("editNum") List<String> editNum);

    //采购药材记录
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "insert into stock_consum(stock_num,stock_name,stock_money)(select consumables_num,consumables_name,consumables_price from consumables where consumables_num in (:editNum))")
    int addHistroy(@Param("editNum") List<String> editNum);

    //采购药材记录数量
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update stock_consum set stock_number=:consumablesNumber where stock_num in (:editNum)")
    int addHistoryNumber(@Param("consumablesNumber") int consumablesNumber, @Param("editNum") List<String> editNum);

    //计算药材总价
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update stock_consum set stock_price=:consumablesNumber*stock_money where stock_num in(:editNum)")
    int addHistoryPrice(@Param("consumablesNumber") int consumablesNumber, @Param("editNum") List<String> editNum);
}
