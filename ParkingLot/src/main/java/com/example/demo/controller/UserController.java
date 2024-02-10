package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.ResponseEntity;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.UserModel;
import com.example.demo.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IUserService userService;

	@PostMapping("/registerUser")
	public ResponseEntity registerUser(@RequestBody UserDTO userDTO) {
		UserModel register = userService.register(userDTO);
		return new ResponseEntity(register, "Registered successfully");
	}

	@GetMapping("/login")
	public ResponseEntity login(@RequestBody LoginDTO loginDTO) {
		String login = userService.login(loginDTO);
		System.out.println("Login SuccessFully!!!");
		return new ResponseEntity(login, "Login successfully");
	}

	@GetMapping("/getAllUsers")
	public ResponseEntity getAllUser(@RequestParam String role) {
		List<UserDTO> userDTO = userService.getAllUsers(role);
		return new ResponseEntity(userDTO, "Fetched Users successfully");
	}

	@GetMapping("/logout")
	public ResponseEntity logout(@RequestHeader String token) {
		String logout = userService.logout(token);
		System.out.println("Logout SuccessFully!!!");
		return new ResponseEntity(logout, "Logout successfully");
	}

	
}
