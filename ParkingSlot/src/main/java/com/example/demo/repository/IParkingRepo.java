package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.ParkingSlotModel;

@Repository
public interface IParkingRepo extends JpaRepository<ParkingSlotModel, Long>{

	Optional<ParkingSlotModel> findBySlotId(Long slotId);

	Optional<ParkingSlotModel> findBySlotId(Long slotId, Long slotId2);
	
	public List<ParkingSlotModel> findBySlotAvailable(boolean isAvailable);
}
