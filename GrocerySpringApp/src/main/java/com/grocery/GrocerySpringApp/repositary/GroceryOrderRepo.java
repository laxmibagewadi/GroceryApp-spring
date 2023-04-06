package com.grocery.GrocerySpringApp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.GrocerySpringApp.dto.GroceryOrder;

public interface GroceryOrderRepo extends JpaRepository<GroceryOrder, Integer>{

}
