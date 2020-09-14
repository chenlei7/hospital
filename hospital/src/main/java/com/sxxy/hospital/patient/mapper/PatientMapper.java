package com.sxxy.hospital.patient.mapper;

import com.sxxy.hospital.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMapper extends JpaRepository<Patient,Integer> {

}
