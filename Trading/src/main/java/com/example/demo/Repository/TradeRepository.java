package com.example.demo.Repository;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.TradeModel;


public interface TradeRepository extends JpaRepository<TradeModel, Integer>{

	Iterable<TradeModel> save(List<TradeModel> users);

	void save(ClassPathResource staticDataResource);

	TradeModel save(String fileName);

	

	Optional<TradeModel> findBylastTradeTime(String lastTradeTime);

	void save(InputStream inputStream);

	Optional<TradeModel> findById(String id);

	void save(Optional<TradeModel> trades);

	TradeModel save(TradeModel fileDB);

	

}
