package com.example.demo.vo;

import com.example.demo.model.UserModel;

public class ResponseTemplateVO {
  
	private UserModel userModel;
	private ParkingSlot parkingSlot;
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public ParkingSlot getParkingSlot() {
		return parkingSlot;
	}
	public void setParkingSlot(ParkingSlot parkingSlot) {
		this.parkingSlot = parkingSlot;
	}
	public ResponseTemplateVO(UserModel userModel, ParkingSlot parkingSlot) {
		super();
		this.userModel = userModel;
		this.parkingSlot = parkingSlot;
	}
	public ResponseTemplateVO() {
		super();
	}
	
}
