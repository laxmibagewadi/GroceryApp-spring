package com.grocery.GrocerySpringApp.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
@Entity
public class GroceryOrder {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
   @CreationTimestamp
	private LocalDateTime datetime;
	private double totalcost;
	private String status;
	
	@OneToMany(mappedBy="groceryorder")
	private List<Iteam> items;
	
	
	public List<Iteam> getItems() {
		return items;
	}
	public void setItems(List<Iteam> items) {
		this.items = items;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public double getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
