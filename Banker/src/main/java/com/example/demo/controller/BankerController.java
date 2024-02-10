package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BankerModel;
import com.example.demo.service.BankerService;
import com.example.demo.service.IBankerService;
import com.example.demo.utils.PdfGenerator;
import com.lowagie.text.DocumentException;

import jakarta.servlet.http.HttpServletResponse;

@RestController
//@RequestMapping("/bank")
public class BankerController {

	@Autowired
	IBankerService service;
	
	@PostMapping("/addCustomer")
	public BankerModel addCustomer(@RequestBody BankerModel model) {
		BankerModel bank = service.addCustomer(model);
		return model;
	}
	
	@GetMapping("/getAll")
	public List<BankerModel> getAll(BankerModel model){
		List<BankerModel> get = service.getAll(model);
		return get;
		
	}
	
	 @GetMapping("/export-to-pdf")
	  public void generatePdfFile(HttpServletResponse response, BankerModel model) throws DocumentException, IOException 
	  {
	    response.setContentType("application/pdf");
	    DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
	    String currentDateTime = dateFormat.format(new Date());
	    String headerkey = "Content-Disposition";
	    String headervalue = "attachment; filename=student" + currentDateTime + ".pdf";
	    response.setHeader(headerkey, headervalue);
	    List < BankerModel > listofStudents = service.getAll(model);
	    PdfGenerator generator = new PdfGenerator();
	    generator.generate(listofStudents, response);
	  }
}
