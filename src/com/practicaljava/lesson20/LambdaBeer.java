package com.practicaljava.lesson20;

/**
 * A class for demonstrating Streams.
 * 
 * @author David Lall
 *
 */

public class LambdaBeer {
	public String name;
	public String country;
	public float price;
	
	LambdaBeer(String name, String country, float price) {
		this.name = name;
		this.country = country;
		this.price = price;
	}
	
	public String toString() {
		return "Name: " + name + ", price: " + price;
	}
}