package com.ganesh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PriceController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	List<Price> priceList = new ArrayList<Price>();
	
	@GetMapping("/price/{productId}")
	public Price getProductDetails(@PathVariable Long productId) {
 		// 1. Get Price
		Price price = getPriceInfo(productId);
		
		// 2 Call Exchange Service to change price
		Integer exchangeValue = restTemplate.getForObject("http://localhost:7773/currexg/from/USD/to/YEN", ExchangeValue.class)
				.getExchangeValue();
		
		//return price;
		return new Price(price.getPriceId(), price.getProductId(), price.getOriginalPrice(), 
				Math.multiplyExact(exchangeValue, price.getDiscountedPrice()));
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
