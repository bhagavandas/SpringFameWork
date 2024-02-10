package com.example.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.Model.TradeModel;
import com.example.demo.Repository.TradeRepository;
import com.example.demo.Service.TradeService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@EnableTransactionManagement
@EntityScan()
@SpringBootApplication
public class TradingApplication {

	@Autowired
	static
	TradeRepository tradeRepository;
	TradeService tradeService;
	public static void main(String[] args) {
		SpringApplication.run(TradingApplication.class, args);
		
//		getData();
	}
	
	@Bean
	CommandLineRunner runner(TradeService tradeService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			TypeReference<List<TradeModel>> typeReference = new TypeReference<List<TradeModel>>(){};
			System.out.println("Logging........");
			InputStream inputStream = TypeReference.class.getResourceAsStream("/jsontimeseries5min.txt");
			try {
				List<TradeModel> users = mapper.readValue(inputStream,typeReference);
				tradeService.save(users);
				tradeRepository.save(inputStream);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}
	
}
