package com.sxxy.hospital.user.mapper;

import com.sxxy.hospital.user.entity.ChineseEpidemic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChineseEpidemicMapper extends JpaRepository<ChineseEpidemic,Integer> {

}
