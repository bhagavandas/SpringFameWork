package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.demo.ResponseEntity;
import com.example.demo.model.HospitalModel;
import com.example.demo.service.IHospitalService;


@RestController
@RequestMapping("/hospital")
public class HospitalController {


	@Autowired
	IHospitalService hospitalService;
	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/add")
	public ResponseEntity registerUser(@RequestBody HospitalModel hospitalModel) {
		HospitalModel hospital = hospitalService.add(hospitalModel);
		return new ResponseEntity(hospital, "Added successfully");
	}
	
	@GetMapping("/{hospitalId}")
	public ResponseEntity getHospital(@PathVariable HospitalModel hospitalId) {
		HospitalModel hospital = hospitalService.findByHospitalId(hospitalId);
		return new ResponseEntity(hospital, "Fetched successfully");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
