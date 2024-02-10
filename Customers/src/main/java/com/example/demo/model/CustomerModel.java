package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerModel {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long userId;
		private String firstName;
		private String lastName;
		private String address;
		private long phoneNumber;
		private String email;
		private String password;
		
		
		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public long getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
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

		public CustomerModel(Long userId, String firstName, String lastName, String address, long phoneNumber, String email,
				String password) {
			super();
			userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.phoneNumber = phoneNumber;
			this.email = email;
			this.password = password;
		}
		
		public CustomerModel() {
			
		}
		

	}


