package com.example.demo.Service;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Model.TradeDTO;
import com.example.demo.Model.TradeModel;
import com.example.demo.Repository.TradeRepository;
import com.example.demo.exceptions.TradeException;





@Service
public class TradeService {
	 @Autowired
	 private final TradeRepository tradeRepository;
	 
	 	@Autowired
		ModelMapper modelMapper;
	 
	    public TradeService(TradeRepository tradeRepository) {
	        this.tradeRepository = tradeRepository;
	    }

	    public Iterable<TradeModel> list() {
	        return tradeRepository.findAll();
	    }

	    public Iterable<TradeModel> save(List<TradeModel> users) {
	        return tradeRepository.save(users);
	    }
	    
	    public TradeModel store(MultipartFile file) throws IOException {
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	        TradeModel FileDB = new TradeModel();

	        return tradeRepository.save(FileDB);
	      }

		public void save(ClassPathResource staticDataResource) {
			// TODO Auto-generated method stub
			
		}

		public TradeModel findTrade(String lastTradeTime) {
			Optional<TradeModel> model = tradeRepository.findBylastTradeTime(lastTradeTime);
			if (model.isEmpty()) {
				System.out.println("Doesnt exist");
			}
			TradeModel registerDTO = modelMapper.map(model, TradeModel.class);

			return registerDTO;
		}

	
		
		public Optional<TradeModel> add(TradeDTO tradeDTO) {
			Optional<TradeModel> tradeModel = tradeRepository.findById(tradeDTO.getId());
			if (tradeModel.isPresent()) {
				throw new TradeException("ID already exists!!");
			}
			
			TradeModel trade = modelMapper.map(tradeDTO, TradeModel.class);
			
			tradeRepository.save(trade);

			System.out.println("Successfully added");
			return tradeModel;
		}

		
		
		public TradeDTO searchById(int id) {
			Optional<TradeModel> tradeModel = tradeRepository.findById(id);
			if (tradeModel.isEmpty()) {
				throw new TradeException("Id doesn't exist!!!");
			}
			TradeDTO tradeDTO = modelMapper.map(tradeModel.get(), TradeDTO.class);

			return tradeDTO;
		}
}
