package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResponseEntity;
import com.example.demo.model.ParkingSlotModel;
import com.example.demo.service.IParkingService;


@RestController
@RequestMapping("/slot")
public class ParkingController {

	@Autowired
	IParkingService parkingService;
	
	@PostMapping
	public ResponseEntity add(@RequestBody ParkingSlotModel parkingModel) {
		ParkingSlotModel model = parkingService.add(parkingModel);
		return new ResponseEntity(model, "Added successfully");
	}
	
	@GetMapping
	ParkingSlotModel getSlotDetails(@RequestBody ParkingSlotModel slot){
		return parkingService.checkSlot(slot);
		
	}
	
	@GetMapping
	@ResponseBody List<ParkingSlotModel> getAvailableSlot() {
		return parkingService.checkAndGetAvailableParkingSlot();
	}
	
	@GetMapping("info/{slotId}")
	@ResponseBody ParkingSlotModel specificParkingSlotInfo(@PathVariable Long slotId) {
		return parkingService.checkSpecificParkingSlot(slotId);
	}
	
	@GetMapping("check/{slotId}")
	String specificParkingSlotAvailablityCheck(@PathVariable Long slotId) {
		boolean isAvailable = parkingService.checkSpecificParkingSlotIsAvailable(slotId);
		if(isAvailable) 
			return ("The Parking slot "+slotId+" is Available") ;
		else return( "The Parking slot "+slotId+" is not Available"); 
	}
	
	
}
