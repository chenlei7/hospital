package com.sxxy.hospital.user.mapper;

import com.sxxy.hospital.user.entity.WorldEpidemic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldEpidemicMapper extends JpaRepository<WorldEpidemic,Integer> {
}
