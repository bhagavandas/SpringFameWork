package com.example.demo.repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.HospitalModel;


@Repository
public interface HospitalRepository extends JpaRepository<HospitalModel, Long> {

	Optional<HospitalModel> findByDepartment(String hospital);

	HospitalModel findByHospitalId(Long hospitalId);



	
}
