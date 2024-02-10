package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.UserModel;
import com.example.demo.vo.ResponseTemplateVO;

public interface IUserService {

	
	UserModel register(UserDTO userDTO);

	String login(LoginDTO loginDTO);

	List<UserDTO> getAllUsers(String role);

	String logout(String token);

	ResponseTemplateVO getSlotAvailability(Long slotId);

}
