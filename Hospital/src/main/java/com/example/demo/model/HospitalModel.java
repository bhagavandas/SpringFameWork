package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hospital_list")
public class HospitalModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long hospitalId;
	private String department;
	private String hospitalName;
	
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public HospitalModel(Long hospitalId, String department, String hospitalName) {
		super();
		this.hospitalId = hospitalId;
		this.department = department;
		this.hospitalName = hospitalName;
	}
	public HospitalModel() {
		
	}
	
}
