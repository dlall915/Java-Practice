package com.practicaljava.lesson22;

public class Order {
	int orderID;
	String stockSymbol;
	int quantity;
	float price;
	
	public Order(int id, String stockSymbol, int quantity, float price) {
		orderID = id;
		this.stockSymbol = stockSymbol;
		this.quantity = quantity;
		this.price = price;
	}
}