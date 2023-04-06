package com.grocery.GrocerySpringApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grocery.GrocerySpringApp.dto.GroceryOrder;
import com.grocery.GrocerySpringApp.dto.Iteam;
import com.grocery.GrocerySpringApp.repositary.GroceryOrderRepo;
import com.grocery.GrocerySpringApp.repositary.IteamRepo;

@Repository
public class GroceryOrderDao {

	@Autowired
	GroceryOrderRepo groceryorderrepo;
	
	@Autowired
	IteamRepo iteamrepo;
	
	public GroceryOrder saveGroceryOrder(GroceryOrder groceryOrder) {
		List<Iteam> listOfItems = groceryOrder.getItems();
		List<Iteam> res = new ArrayList<>();
		if (listOfItems.isEmpty()) {
			groceryOrder = groceryorderrepo.save(groceryOrder);
		} else {
			groceryOrder = groceryorderrepo.save(groceryOrder);
			for (Iteam iteam : listOfItems) {
				iteam.setGroceryorder(groceryOrder);
				res.add(iteamrepo.save(iteam));
			}
			groceryOrder.setItems(res);
		}
		return groceryOrder;		 
	}
	public Optional<GroceryOrder> getGroceryOrderById(int id) {
		return groceryorderrepo.findById(id);
	}

	public List<GroceryOrder> getAllGroceryOrder() {
		return groceryorderrepo.findAll();
	}

	public GroceryOrder updateGroceryOrder(GroceryOrder groceryOrder) {
		return groceryorderrepo.save(groceryOrder);
	}

	public void deleteGroceryOrder(int id) {
		groceryorderrepo.deleteById(id);
	}


}
