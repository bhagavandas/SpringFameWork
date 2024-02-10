package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.CustomerDTO;
import com.example.demo.model.CustomerModel;
import com.example.demo.service.ICustomerService;

@RestController
public class CustomerController {


	@Autowired
	ICustomerService customerService;
	

	@PostMapping("/addUser")
	public ResponseEntity registerUser(@RequestBody CustomerDTO userDTO) {
		CustomerDTO user = customerService.add(userDTO);
		return new ResponseEntity(user, "Added successfully");
	}
	
	
	
	@GetMapping("/getBooks")
	public ResponseEntity getAllCustomers() {
		List<CustomerModel> bookModel = customerService.getAllCustomers();
		return new ResponseEntity(bookModel, "Fetched Books successfully");
	}
	

}
