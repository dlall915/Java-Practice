package com.practicaljava.lesson06;

/**
 * Creates an array of mixed workers, employees and contractors, and attempts
 * to give them all a 30% pay increase.
 * 
 * @author David Lall
 */

class TestPayIncrease {
	public static void main (String[] args) {
		Person workers[] = new Person[3];
		workers[0] = new Employee("Bob");
		workers[1] = new Contractor("Mary");
		workers[2] = new Employee("Steve");
		Employee currentEmployee;
		Contractor currentContractor;
		for (Person p : workers) {
			if (p instanceof Employee) {
				currentEmployee = (Employee)p;
				currentEmployee.increasePay(30);
			}
			else if (p instanceof Contractor) {
				currentContractor = (Contractor)p;
				currentContractor.increasePay(30);
			}
		}
	}
}