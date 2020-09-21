package com.sxxy.hospital.personnel.mapper;

import com.sxxy.hospital.personnel.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceMapper extends JpaRepository<Attendance,Object> {
}
