package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BankerModel;

@Repository
public interface BankerRepo extends JpaRepository<BankerModel,Integer>{

	Optional<BankerModel> findByPhoneNumber(String phoneNumber);
	
	

}
