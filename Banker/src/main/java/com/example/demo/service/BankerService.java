package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BankerModel;
import com.example.demo.repo.BankerRepo;

@Service
public class BankerService implements IBankerService{

	@Autowired
	BankerRepo repo;
	
	
	public BankerModel addCustomer(BankerModel model) {
		Optional<BankerModel> bank = repo.findByPhoneNumber(model.getPhoneNumber());
		if(bank.isEmpty()) {
			repo.save(model);
		}else {
			Exception e;
			System.out.println("Already Exists");
		}
		return model;
	}


	@Override
	public List<BankerModel> getAll(BankerModel model) {
		List<BankerModel> get = repo.findAll();
		return get;
	}

}
