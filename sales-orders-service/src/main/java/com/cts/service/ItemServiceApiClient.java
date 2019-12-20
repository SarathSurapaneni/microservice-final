package com.cts.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.model.Item;



//@FeignClient(name="item-service",fallback=ItemServiceFallback.class,url="https://291363-item-service.cfapps.io")
@FeignClient(name="item-service",fallback=ItemServiceFallback.class)
public interface ItemServiceApiClient {

	@GetMapping("/service2/items/{itemname}")
	  Item getItemByItemName(@PathVariable("itemname") String itemName);
}

@Component
class ItemServiceFallback implements ItemServiceApiClient{

	@Override
	public Item getItemByItemName(@PathVariable("itemname") String itemName) {
		return new Item();
	}
	 
 }
