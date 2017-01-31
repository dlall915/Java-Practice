package com.practicaljava.lesson06;

/**
 * Class for an employee. Employees do not have a limitation on pay increases.
 * 
 * @author David Lall
 */

public class Employee extends Person implements Payable {

	public Employee(String name) {
		super(name);
	}

	@Override
	public boolean increasePay(int percent) {
		System.out.println("Increasing salary by " + percent + "%. " +
				getName());
		return true;
	}
	
}