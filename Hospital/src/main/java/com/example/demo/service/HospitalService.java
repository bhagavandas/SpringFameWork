package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.HospitalModel;
import com.example.demo.repository.HospitalRepository;

@Service
public class HospitalService implements IHospitalService{

	@Autowired
	HospitalRepository hospitalRepo;

	@Override
	public HospitalModel add(HospitalModel hospitalModel) {
		hospitalRepo.save(hospitalModel);
		return hospitalModel;
	}

	@Override
	public HospitalModel findByHospitalId(HospitalModel hospitalModel) {
		return hospitalRepo.findByHospitalId(hospitalModel.getHospitalId());
	}

	
}
