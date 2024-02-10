package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.example.demo.Enum.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String name;
	private String email;
	private String password;
	private Role role;
	private int parkingSlot;

	public int getId() {
		return userId;
	}

	public void setId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getParkingSlot() {
		return parkingSlot;
	}

	public void setParkingSlot(int parkingSlot) {
		this.parkingSlot = parkingSlot;
	}

	public UserModel(int userId, String name, String email, String password, Role role,
			int parkingSlot) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		
		this.role = role;
		this.parkingSlot = parkingSlot;
	}

	public UserModel() {
		super();
	}

}
