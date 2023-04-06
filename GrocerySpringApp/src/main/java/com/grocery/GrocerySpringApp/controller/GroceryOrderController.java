package com.grocery.GrocerySpringApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.GrocerySpringApp.dao.GroceryOrderDao;
import com.grocery.GrocerySpringApp.dto.GroceryOrder;

@RestController
@RequestMapping("/GroceryOrders")
public class GroceryOrderController {

	@Autowired
	GroceryOrderDao groceryorderdao;
	
	@PostMapping
	public GroceryOrder placeGroceryOrder(@RequestBody GroceryOrder groceryOrder) {
		return groceryorderdao.saveGroceryOrder(groceryOrder);
		

}
	@GetMapping("/{id}")
	public GroceryOrder getGroceryById(@PathVariable int id) {
		Optional<GroceryOrder> op =groceryorderdao .getGroceryOrderById(id);
		if (op.isPresent()) {
			return null;
		} else {
			return op.get();
		}
	}
	
	@GetMapping
	public List<GroceryOrder> getAllGroceryOrder()
	{
		return groceryorderdao.getAllGroceryOrder();
	}
	
	@PutMapping
	public GroceryOrder updateGroceryOrder(@RequestBody GroceryOrder groceryOrder) {
		return groceryorderdao.updateGroceryOrder(groceryOrder);
	}
	@DeleteMapping
	public String deleteGroceryOrder(@RequestParam int id) {
		Optional<GroceryOrder> op = groceryorderdao.getGroceryOrderById(id);
		if (op.isPresent()) {
			groceryorderdao.deleteGroceryOrder(id);
			return " data deleted";
		} else {
			return " data not found";
		}
	}
}
