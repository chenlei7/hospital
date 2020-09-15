package com.sxxy.hospital.user.mapper;


import com.sxxy.hospital.user.entity.EpidemicProtection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpidemicProtectionMapper extends JpaRepository<EpidemicProtection,Object> {

}
