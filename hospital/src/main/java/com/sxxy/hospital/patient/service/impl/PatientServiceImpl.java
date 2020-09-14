package com.sxxy.hospital.patient.service.impl;

import com.sxxy.hospital.patient.mapper.PatientMapper;
import com.sxxy.hospital.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientMapper patientMapper;


}
