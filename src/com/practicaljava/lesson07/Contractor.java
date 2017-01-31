package com.practicaljava.lesson07;

/**
 * Contractor class, pay raise is done by a percentage of the hourly rate.
 * 
 * @author David Lall
 *
 */

class Contractor extends Person {

	public Contractor(String name) {
		super(name);
	}

	@Override
	public boolean increasePay(int percent) {
		if (percent < INCREASE_CAP) {
			System.out.println("Increasing hourly rate by " + percent + "%." 
					+ getName());
			return true;
		}
		else {
			System.out.println("Sorry, can't increase hourly rate by more " +
					"than " + INCREASE_CAP + "%." + getName());
			return false;
		}
	}
}