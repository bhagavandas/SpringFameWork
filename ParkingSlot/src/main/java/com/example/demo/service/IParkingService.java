package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ParkingSlotModel;

public interface IParkingService {

	ParkingSlotModel add(ParkingSlotModel parkingModel);

	ParkingSlotModel checkSlot(ParkingSlotModel slot);

	List<ParkingSlotModel> checkAndGetAvailableParkingSlot();

	ParkingSlotModel checkSpecificParkingSlot(Long slotId);

	boolean checkSpecificParkingSlotIsAvailable(Long slotId);

}
