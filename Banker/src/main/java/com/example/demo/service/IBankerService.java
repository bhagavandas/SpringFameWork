package com.example.demo.service;

import java.util.List;

import com.example.demo.model.BankerModel;

public interface IBankerService {

	BankerModel addCustomer(BankerModel model);

	List<BankerModel> getAll(BankerModel model);

}
