package com.practicaljava.lesson06;

public class ForeignContractor extends Person {
	public ForeignContractor(String name) {
		super(name);
	}
	public boolean icnreasePay(int percent) {
		System.out.println("I'm just a foreign worker");
		return true;
	}
}