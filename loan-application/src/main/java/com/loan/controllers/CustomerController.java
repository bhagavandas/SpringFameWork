package com.loan.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.loan.models.Customer;
import com.loan.services.impl.CustomerServiceImpl;

@RestController
//@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerService;

	private Logger logger = Logger.getLogger(getClass());

	// Adding Customer

	@PostMapping("/add")
	public Customer addCustomer(@RequestBody Customer c) {
		Customer cust = customerService.addCustomer(c);
		if (cust != null) {
			logger.info("Customer Registered Successfully");
			return cust;
		} else {
			logger.error("Customer Registration Failed");
			return null;
		}
	}
	// Updating Customer

	@PutMapping
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(c), HttpStatus.OK);
	}

	// Fetching all Customers

	@GetMapping
	public ResponseEntity<List<Customer>> getCustomers(@RequestParam("page") int pageNumber,
			@RequestParam("size") int pageSize) {
		return new ResponseEntity<List<Customer>>(customerService.getCustomers(pageNumber, pageSize), HttpStatus.OK);
	}

	// Customer Login

	@PostMapping("/login")
	public ResponseEntity<Integer> doLogin(@RequestParam String email, @RequestParam String password) {
		return new ResponseEntity<Integer>(customerService.doLogin(email, password), HttpStatus.OK);
	}

	// Fetching Customer By Customer Id

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		return new ResponseEntity<Customer>(customerService.getCustomerById(id), HttpStatus.OK);
	}
}
