package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.VO.ResponseTemplateVO;
import com.example.demo.model.PatientModel;

public interface IPatientService {

	PatientModel add(PatientModel patientModel);

	ResponseTemplateVO getPatientWithHospital(Long patientId);

	


}
