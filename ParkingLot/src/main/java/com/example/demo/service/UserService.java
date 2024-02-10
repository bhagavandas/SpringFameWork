package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.UserException;
import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepo;
import com.example.demo.utilities.JwtTokenUtil;
import com.example.demo.vo.ParkingSlot;
import com.example.demo.vo.ResponseTemplateVO;

import io.jsonwebtoken.Jwt;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserRepo repo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	JwtTokenUtil tokenUtil;
	@Autowired
	RestTemplate restTemplate;
		
	@Override
	public UserModel register(UserDTO userDTO) {
		Optional<UserModel> userModel = repo.findByEmailAndPassword(userDTO.getEmail(),userDTO.getPassword());
		if (userModel.isPresent()) {
			throw new UserException("Email already exists!!");
		}
		
		UserModel registeredUser = modelMapper.map(userDTO, UserModel.class);
		
		repo.save(registeredUser);

		System.out.println("Successfully registered");
		return registeredUser;
	}

	@Override
	public String login(LoginDTO loginDTO) {
		Optional<UserModel> userModel = repo.findByEmailAndPassword(loginDTO.getEmail(),
				loginDTO.getPassword());
		if (userModel.isEmpty()) {
			Optional<UserModel> userEmail = repo.findByEmail(loginDTO.getEmail());
			Optional<UserModel> userPassword = repo.findByPassword(loginDTO.getPassword());
			if (userEmail.isEmpty()) {
				throw new UserException("Entered Email is incorrect");
			} else if (userPassword.isEmpty()) {
				throw new UserException("Entered Password is incorrect");
			}
		}
		String token = tokenUtil.generateToken(loginDTO);
		
		repo.save(userModel.get());
		return token;
	}
	
	public List<UserDTO> getAllUsers(String role) {
		if (role.equals("Admin"))
			return repo.findAll().stream().map(user -> modelMapper.map(user, UserDTO.class))
					.collect(Collectors.toList());
		else {
			throw new UserException("You are not an Admin, Please check your Role");
		}
	}

	@Override
	public String logout(String token) {
		LoginDTO loginDTO = tokenUtil.deCode(token);
		Optional<UserModel> checkUser = repo.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
		
		repo.save(checkUser.get());
		return "logout successful";
	}
	
	@Override
	public ResponseTemplateVO getSlotAvailability(Long slotId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		UserModel user = repo.findByUserId(slotId);
		ParkingSlot slot = restTemplate.getForObject("http://localhost:8071/slot/" + user.getId(), ParkingSlot.class);
		vo.setParkingSlot(slot);
		vo.setUserModel(user);
		
		return vo;
		
	}
}
