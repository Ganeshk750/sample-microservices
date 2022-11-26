package com.ganesh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	List<ProductInfo> productList = new ArrayList<ProductInfo>();
	
	@GetMapping("/product/details/{productId}")
	public Product getProductDetails(@PathVariable Long productId) {
 		// 1. Get Name and Description From Product Service
		ProductInfo info = getProductInfo(productId);
		
		// 2. Getting price from pricing service
		Price price = restTemplate.getForObject("http://localhost:7771/price/"+ productId, Price.class);
		
		// 3. Getting stock from inventory service
		Inventory inventory = restTemplate.getForObject("http://localhost:7772/inventory/"+ productId, Inventory.class);
		
		//return new Product(info.getProductId(), info.getProductName(), info.getProductDescription(), 999, true);
		return new Product(info.getProductId(), info.getProductName(), info.getProductDescription(), 
				price.getDiscountedPrice(), inventory.getInStock());
	}

	private ProductInfo getProductInfo(Long productId) {
		populateProductList();
		for(ProductInfo p: productList) {
			if(p.getProductId().equals(productId)) {
				return p;
			}
		}
		return null;
	}

	private void populateProductList() {
		productList.clear();;
		productList.add(new ProductInfo(101L, "Iphone", "It is very Costely"));
		productList.add(new ProductInfo(102L, "LapTop", "It is useful for students"));
		productList.add(new ProductInfo(103L, "Book", "It is also useful for all kinds of Students"));
		
	}
	
	

}
