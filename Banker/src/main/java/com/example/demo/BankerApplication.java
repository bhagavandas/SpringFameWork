package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.BankerModel;
import com.example.demo.service.BankerService;

@SpringBootApplication
public class BankerApplication {

	@Autowired
	BankerService service;
	
	public static void main(String[] args) {
		SpringApplication.run(BankerApplication.class, args);
	}

//	 public void run(String...a) {
//	    for (int i = 0; i <= 10; i++) {
//	      BankerModel student = new BankerModel();
//	      student.setName("Das");
//	      student.setEmail("das@mail.com");
//	      student.setPhoneNumber(null);
//	      service.addCustomer(student);
//	    }
//	  }
}
