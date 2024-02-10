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
import com.example.demo.ResponseEntity;
import com.example.demo.VO.ResponseTemplateVO;
import com.example.demo.model.PatientModel;
import com.example.demo.service.IPatientService;

@RestController
@RequestMapping("/patient")
public class Controller {
	
	@Autowired
	IPatientService service;
	

	@PostMapping("/add")
	public ResponseEntity registerUser(@RequestBody PatientModel patientModel) {
		PatientModel patient = service.add(patientModel);
		return new ResponseEntity(patientModel, "Added successfully");
	}
	@GetMapping("/{patientId}")
	public ResponseTemplateVO getPatientWithHospital(@PathVariable Long patientId) {
		
		return service.getPatientWithHospital(patientId);
		
	}
}
