package com.ganesh;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
	
	List<Inventory> inventorytList = new ArrayList<Inventory>();
	
	@GetMapping("/inventory/{productId}")
	public Inventory getInventoryDetails(@PathVariable Long productId) {
 		
		Inventory in = getInventoryInfo(productId);
		
		return in;
	}

	private Inventory getInventoryInfo(Long productId) {
		populateInventoryList();
		for(Inventory inventory: inventorytList) {
			if(inventory.getProductId().equals(productId)) {
				return inventory;
			}
		}
		return null;
	}

	private void populateInventoryList() {
		inventorytList.clear();
		inventorytList.add(new Inventory(301L, 101L, true));
		inventorytList.add(new Inventory(302L, 102L, true));
		inventorytList.add(new Inventory(303L, 103L, false));
		
	}
	
	

}
