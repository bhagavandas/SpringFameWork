package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.exceptions.CustomerException;
import com.example.demo.model.CustomerModel;
import com.example.demo.repository.IUserRepository;




@Service
public class CustomerService implements ICustomerService{
	
	@Autowired
	IUserRepository repo;
	@Autowired
	ModelMapper modelMapper;
	
	
	@Override
	public CustomerDTO add(CustomerDTO userDTO) {
		Optional<CustomerModel> userModel = repo.findByFirstName(userDTO.getFirstName());
		if (userModel.isPresent()) {
			throw new CustomerException("User already exists!!");
		}
		CustomerModel user = modelMapper.map(userDTO, CustomerModel.class);

		repo.save(user);

		System.out.println("Successfully added");
		return userDTO;
	}
	
	@Override
	public CustomerDTO delete(CustomerDTO userDTO) {
		Optional<CustomerModel> userModel = repo.findByFirstName(userDTO.getFirstName());
		if (userModel.isPresent()) {
			repo.deleteByFirstName(userModel);
			
		}else
			throw new CustomerException("User doesnt exists!!");
		CustomerModel user = modelMapper.map(userDTO, CustomerModel.class);

		

		System.out.println("Successfully deleted");
		return userDTO;
	}
	
	
		
	
	public List<CustomerModel> getAllCustomers() {
		
		return repo.findAll().stream().map(employee -> modelMapper.map(employee, CustomerModel.class))
				.collect(Collectors.toList());	
			
	
	}

	
	



	

}
