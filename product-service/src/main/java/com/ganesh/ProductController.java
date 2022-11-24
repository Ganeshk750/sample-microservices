package com.ganesh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	List<ProductInfo> productList = new ArrayList<ProductInfo>();
	
	@GetMapping("/product/details/{productId}")
	public Product getProductDetails(@PathVariable Long productId) {
 		// 1. Get Name and Description From Product Service
		ProductInfo info = getProductInfo(productId);
		
		return new Product(info.getProductId(), info.getProductName(), info.getProductDescription(), 999, true);
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
		productList.add(new ProductInfo(101L, "Iphone", "It is very Costely"));
		productList.add(new ProductInfo(102L, "LapTop", "It is useful for students"));
		productList.add(new ProductInfo(103L, "Book", "It is also useful for all kinds of Students"));
		
	}
	
	

}
