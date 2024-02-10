package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.VO.Hospital;
import com.example.demo.VO.ResponseTemplateVO;
import com.example.demo.model.PatientModel;
import com.example.demo.repository.IPatientRepository;

@Service
public class PatientService implements IPatientService {

	@Autowired
	IPatientRepository repo;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public PatientModel add(PatientModel patientModel) {
		PatientModel patient = repo.findByPatientName(patientModel.getPatientName());
		repo.save(patientModel);
		return patientModel;
	}

	@Override
	public ResponseTemplateVO getPatientWithHospital(Long patientId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		PatientModel patient = repo.findByPatientId(patientId);
		Hospital hospital = restTemplate.getForObject("http://localhost:8092/hospital/" + patient.getHospitalId(), Hospital.class);
		vo.setPatientModel(patient);
		vo.setHospital(hospital);
		
		return vo;
		
	}

}
