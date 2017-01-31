package com.practicaljava.lesson06;

/**
 * Class for person, just contains the name.
 * 
 * @author David Lall
 */

public class Person {
	private String name;
	public Person (String name) {
		this.name = name;
	}
	public String getName() {
		return "Person's name is " + name;
	}
}