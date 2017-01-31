package com.practicaljava.lesson07;

/**
 * Employee class, pay raise is done by a percentage of salary.
 * 
 * @author David Lall
 *
 */

class Employee extends Person {

	public Employee(String name) {
		super(name);
	}

	@Override
	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by " + percent + "%." 
				+ getName());
		return true;
	}	
}