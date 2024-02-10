package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@Table(name = "Patient_list")
public class PatientModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	private String patientName;
	private String hospitalId;
	
	public PatientModel(int patientId, String patientName, String hospitalId) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.hospitalId = hospitalId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public PatientModel() {
		
	}
	
	
	
}
