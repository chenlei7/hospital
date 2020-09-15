package com.sxxy.hospital.patient.service.impl;

import com.sxxy.hospital.patient.entity.Patient;
import com.sxxy.hospital.patient.mapper.PatientMapper;
import com.sxxy.hospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientMapper patientMapper;


   //修改病人
    @Override
    public int PatientUpdate(Patient patient) {
        return patientMapper.PatientUpdate(patient.getPatientLeaveDate(),patient.getPatientIllnessNum(),patient.getPatientNurseNum(),patient.getPatientNum());
    }
}
