package com.practicaljava.lesson20;

/**
 * A class for demonstrating Streams.
 * 
 * @author David Lall
 *
 */

public class Beer implements Comparable<Beer> {
	public String name;
	public String country;
	public float price;
	
	Beer(String name, String country, float price) {
		this.name = name;
		this.country = country;
		this.price = price;
	}
	
	public int compareTo(Beer otherBeer) {
		if (this.price > otherBeer.price) {
			return 1; // this beer is "larger" than the other
		}
		else if (this.price < otherBeer.price) {
			return -1; // this beer is "smaller" than the other
		}
		else {
			return 0; // the beers are "equal"
		}
	}
	
	public String toString() {
		return "Name: " + name + ", price: " + price;
	}
}