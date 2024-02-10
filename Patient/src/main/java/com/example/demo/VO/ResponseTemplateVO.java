package com.example.demo.VO;
import com.example.demo.model.PatientModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ResponseTemplateVO {
  
	private  PatientModel patientModel;
	private Hospital hospital;
	public PatientModel getPatientModel() {
		return patientModel;
	}
	public void setPatientModel(PatientModel patientModel) {
		this.patientModel = patientModel;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public ResponseTemplateVO(PatientModel patientModel, Hospital hospital) {
		super();
		this.patientModel = patientModel;
		this.hospital = hospital;
	}
	public ResponseTemplateVO() {
		
	}
}
