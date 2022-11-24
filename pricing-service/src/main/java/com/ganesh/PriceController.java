package com.ganesh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {
	
	List<Price> priceList = new ArrayList<Price>();
	
	@GetMapping("/price/{productId}")
	public Price getProductDetails(@PathVariable Long productId) {
 		// 1. Get Name and Description From Product Service
		Price price = getPriceInfo(productId);
		
		return price;
	}

	private Price getPriceInfo(Long productId) {
		populatePriceList();
		for(Price p: priceList) {
			if(p.getProductId().equals(productId)) {
				return p;
			}
		}
		return null;
	}

	private void populatePriceList() {
		priceList.add(new Price(201L, 101L, 35000, 17000));
		priceList.add(new Price(202L, 102L, 30000, 25000));
		priceList.add(new Price(203L, 103L, 500, 250));
		
	}
	
	

}
