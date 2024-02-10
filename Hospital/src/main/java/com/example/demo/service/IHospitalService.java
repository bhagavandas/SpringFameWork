package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.model.HospitalModel;


public interface IHospitalService {


	
	HospitalModel add(HospitalModel hospitalModel);

	HospitalModel findByHospitalId(HospitalModel hospitalModel);


}
