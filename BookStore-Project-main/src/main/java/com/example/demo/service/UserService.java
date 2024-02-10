package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BookDTO;
import com.example.demo.DTO.LoginDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exceptions.BookException;
import com.example.demo.model.BookModel;
import com.example.demo.model.UserModel;
import com.example.demo.repository.IUserRepository;
import com.example.demo.utilities.JwtTokenUtil;

@Service
public class UserService implements IUserService{
	
	@Autowired
	IUserRepository repo;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	JwtTokenUtil tokenUtil;
	
	@Override
	public UserDTO add(UserDTO userDTO) {
		Optional<UserModel> userModel = repo.findByFirstName(userDTO.getFirstName());
		if (userModel.isPresent()) {
			throw new BookException("User already exists!!");
		}
		UserModel user = modelMapper.map(userDTO, UserModel.class);

		repo.save(user);

		System.out.println("Successfully added");
		return userDTO;
	}
	
	
	@Override
	public String login(LoginDTO loginDTO) {
		Optional<UserModel> userModel = repo.findByEmailAndPassword(loginDTO.getEmail(),
				loginDTO.getPassword());
		if (userModel.isEmpty()) {
			Optional<UserModel> userEmail = repo.findByEmail(loginDTO.getEmail());
			Optional<UserModel> userPassword = repo.findByPassword(loginDTO.getPassword());
			if (userEmail.isEmpty()) {
				throw new BookException("Entered Email is incorrect");
			} else if (userPassword.isEmpty()) {
				throw new BookException("Entered Password is incorrect");
			}
		}
		String token = tokenUtil.generateToken(loginDTO);
		
		repo.save(userModel.get());
		return token;
	}
	
	public List<BookModel> getAllBooks() {
		
		return repo.findAll().stream().map(employee -> modelMapper.map(employee, BookModel.class))
				.collect(Collectors.toList());	
			
	
	}

	

}
