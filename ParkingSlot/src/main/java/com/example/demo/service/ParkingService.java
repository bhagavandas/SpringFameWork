package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exceptions.SlotAvailableException;
import com.example.demo.model.ParkingSlotModel;
import com.example.demo.repository.IParkingRepo;

@Service
public class ParkingService implements IParkingService {

	@Autowired
	IParkingRepo repo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ParkingSlotModel add(ParkingSlotModel parkingModel) {

		Optional<ParkingSlotModel> slotModel = repo.findBySlotId(parkingModel.getSlotId());
		if (slotModel.isPresent()) {
			throw new SlotAvailableException("Slot already exists!!");
		}

		ParkingSlotModel slot = modelMapper.map(slotModel, ParkingSlotModel.class);

		repo.save(slot);

		System.out.println("Slot available");

		return slot;
	}

	@Override
	public ParkingSlotModel checkSlot(ParkingSlotModel slot) {
		Optional<ParkingSlotModel> model = repo.findBySlotId(slot.getSlotId());

		return slot;
	}

	@Override
	public List<ParkingSlotModel> checkAndGetAvailableParkingSlot() {
		List<ParkingSlotModel> parkingSlotList = repo.findAll(/* where(availableParkingSlot()) */);
		return parkingSlotList;
	}

	@Override
	public ParkingSlotModel checkSpecificParkingSlot(Long slotId) {
		Optional<ParkingSlotModel> parkingSlot = repo.findById(slotId);
		if(parkingSlot.isPresent())
			return parkingSlot.get();
			else return null;
	}

	@Override
	public boolean checkSpecificParkingSlotIsAvailable(Long slotId) {
		Optional<ParkingSlotModel> parkingSlot = repo.findById(slotId);
		if(parkingSlot.isPresent())
			return parkingSlot.get().getCarNumber().equals("");
		else return false;
	}

}
