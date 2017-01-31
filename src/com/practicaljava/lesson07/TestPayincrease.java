package com.practicaljava.lesson07;

public class TestPayincrease {
	public static void main (String[] args) {
		Person workers[] = new Person[3];
		workers[0] = new Employee("John");
		workers[1] = new Contractor("Mary");
		workers[2] = new Employee("Steve");
		// important difference here vs using an interface
		// the object type will be evaluated at run time (run-time binding or
		// late binding)
		for (Person p : workers) {
			p.promote(30);
		}
	}
}