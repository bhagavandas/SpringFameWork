package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.CustomerDTO;
import com.example.demo.model.CustomerModel;

public interface ICustomerService {
	
	CustomerDTO add(CustomerDTO userDTO);

	CustomerDTO delete(CustomerDTO userDTO);

	

	List<CustomerModel> getAllCustomers();

	

}
