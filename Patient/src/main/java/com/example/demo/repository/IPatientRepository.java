package com.example.demo.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.demo.model.PatientModel;

@Repository
public interface IPatientRepository extends JpaRepository<PatientModel, Integer> {

	PatientModel findByPatientName(String patientName);


	void save(Optional<PatientModel> patientModel);


	PatientModel findByPatientId(Long patientId);




	
}
