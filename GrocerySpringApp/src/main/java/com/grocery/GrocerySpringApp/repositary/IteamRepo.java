package com.grocery.GrocerySpringApp.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.GrocerySpringApp.dto.Iteam;

public interface IteamRepo extends JpaRepository<Iteam, Integer> {

}
