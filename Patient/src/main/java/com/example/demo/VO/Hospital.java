package com.example.demo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Hospital {
	
	private Long hospitalId;
	private String department;
	private String hospitalName;
	
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
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public Hospital(Long hospitalId, String department, String hospitalName) {
		
		this.hospitalId = hospitalId;
		this.department = department;
		this.hospitalName = hospitalName;
	}
	public Hospital() {
		
	}
	
	
}
