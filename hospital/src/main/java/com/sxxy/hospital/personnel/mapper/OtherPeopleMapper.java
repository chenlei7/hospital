package com.sxxy.hospital.personnel.mapper;

import com.sxxy.hospital.personnel.entity.OtherPeople;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherPeopleMapper extends JpaRepository<OtherPeople,Object> {
}
