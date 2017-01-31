package com.practicaljava.lesson06;

/**
 * Class for a contractor. Contractors have a 20% pay increase limit.
 * 
 * @author David Lall
 */

public class Contractor extends Person implements Payable {

	public Contractor(String name) {
		super(name);
	}

	@Override
	public boolean increasePay(int percent) {
		if (percent <= INCREASE_CAP) {
			System.out.println("Increasing salary by " + percent + "%. " +
					getName());
			return true;
		}
		else {
			System.out.println("Cannot increase salary by more than 20%." +
					getName());
			return false;
		}
	}
	
}