package com.example.demo.vo;

import java.time.LocalDateTime;

import jakarta.persistence.Id;

public class ParkingSlot {

	@Id
	private Long slotId;
	private String carNumber;
	private String carName;
	private String carOwnerName;
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;
	private Double fare;
	
	public Long getSlotId() {
		return slotId;
	}
	public void setSlotId(Long slotId) {
		this.slotId = slotId;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarOwnerName() {
		return carOwnerName;
	}
	public void setCarOwnerName(String carOwnerName) {
		this.carOwnerName = carOwnerName;
	}
	public LocalDateTime getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}
	public LocalDateTime getExitTime() {
		return exitTime;
	}
	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public ParkingSlot(Long slotId, String carNumber, String carName, String carOwnerName, LocalDateTime entryTime,
			LocalDateTime exitTime, Double fare) {
		super();
		this.slotId = slotId;
		this.carNumber = carNumber;
		this.carName = carName;
		this.carOwnerName = carOwnerName;
		this.entryTime = entryTime;
		this.exitTime = exitTime;
		this.fare = fare;
	}
	public ParkingSlot() {
		super();
	}
	
	
	
	
}
