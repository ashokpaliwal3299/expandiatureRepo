package com.example.expendiature.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "expendiature")
public class Expendiature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name="price")
	private double price;
	
	@Column(name="date")
	@Temporal(TemporalType.DATE)
	private Date date;

	public Expendiature() {
		
		}

	public Expendiature(int id, String category, String itemName, int quantity, double price, Date date) {
		super();
		this.id = id;
		this.category = category;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
