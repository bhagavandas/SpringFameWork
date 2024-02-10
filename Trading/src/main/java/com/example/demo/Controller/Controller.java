package com.example.demo.Controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Model.TradeDTO;
import com.example.demo.Model.TradeModel;
import com.example.demo.Repository.TradeRepository;
import com.example.demo.Responser.ResponseMessage;
import com.example.demo.Service.TradeService;

@RestController
@RequestMapping("/tradeCandles")
public class Controller {
	@Autowired
	 TradeService tradeService;
	@Autowired
	TradeRepository tradeRepository;
	 
	 @Autowired
	  private TradeService storageService;
	
	   
	    @GetMapping("/trade")
	    public ResponseEntity<Map<String, Object>> getRadarData() throws IOException {
	        ClassPathResource staticDataResource = new ClassPathResource("jsontimeseries5min.txt");
	        String staticDataString = IOUtils.toString(staticDataResource.getInputStream(), StandardCharsets.UTF_8);
	        storageService.save(staticDataResource);
	        return new ResponseEntity<>(
	            new JSONObject(staticDataString).toMap(),
	            HttpStatus.OK
	        );
	        
	    }

	    @PostMapping("/addTrade")
		public Optional<TradeModel> addTrade(@RequestBody TradeDTO tradeDTO) {
	    	Optional<TradeModel> register = storageService.add(tradeDTO);
			return register;
		}
	    
	    @GetMapping("/searchTrade")
		public TradeDTO searchTrade(@RequestParam int id) {
	    	TradeDTO model = storageService.searchById(id);
			return model;
		}
}
