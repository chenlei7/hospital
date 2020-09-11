package com.sxxy.hospital.personnel.mapper;

import com.sxxy.hospital.personnel.entity.Doctor;
import com.sxxy.hospital.personnel.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseMapper extends JpaRepository<Nurse,Object> {
}
