package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.service.IBookService;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/User")
@CrossOrigin("http://localhost:3000/")
public class UserController {
	
	@Autowired
	IUserService userService;
	@Autowired
	IBookService bookService;

	@PostMapping("/addUser")
	public ResponseEntity registerUser(@RequestBody UserDTO userDTO) {
		UserDTO user = userService.add(userDTO);
		return new ResponseEntity(user, "Added successfully");
	}
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
		System.out.println("LTRying.....");
		String login = userService.login(loginDTO);
		System.out.println("Login SuccessFully!!!");
		return new ResponseEntity(login, "Login successfully");
	}
	
	@GetMapping("/getBooks")
	public ResponseEntity getAllBooks() {
		List<BookDTO> bookModel = bookService.getAllBooks();
		return new ResponseEntity(bookModel, "Fetched Books successfully");
	}

}
