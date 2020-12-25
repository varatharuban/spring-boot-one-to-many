package com.rubanelearning.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubanelearning.entity.Buyer;
import com.rubanelearning.repository.BuyerRepository;
import com.rubanelearning.service.BuyerService;

@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	BuyerRepository buyerRepository;
	
	@Override
	public Buyer save(Buyer buyer) {
		return buyerRepository.save(buyer);
	}

}