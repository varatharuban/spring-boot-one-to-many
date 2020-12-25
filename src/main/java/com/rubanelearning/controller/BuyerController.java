package com.rubanelearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubanelearning.entity.Buyer;
import com.rubanelearning.entity.Order;
import com.rubanelearning.service.BuyerService;

@RestController
public class BuyerController {

	@Autowired
	BuyerService buyerService;
	
	@GetMapping("/save-buyer")
	public Buyer saveBuyer() {
		Buyer buyer = new Buyer();
		buyer.setFirstName("Rahesh");
		buyer.setLastName("Regan");
		buyer.setGender("Male");
		
		Order order1 = new Order();
		order1.setProductName("iPad");
		order1.setQty(2);
		order1.setAmount(230.0);
		order1.setBuyer(buyer);
		
		Order order2 = new Order();
		order2.setProductName("Laptop");
		order2.setQty(3);
		order2.setAmount(789.0);
		order2.setBuyer(buyer);
		
		buyer.getOrders().add(order1);
		buyer.getOrders().add(order2);
		
		return buyerService.save(buyer);
	}
}