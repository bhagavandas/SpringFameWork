package com.example.demo.service;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;

public interface IUserService {
	
	UserDTO add(UserDTO userDTO);

	String login(LoginDTO loginDTO);

}
