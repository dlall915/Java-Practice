package com.practicaljava.lesson03;

class TestTax {
	public static void main (String[] args) {
		NJTax t = new NJTax(); //creating an instance of Tax
		//assigning the values to class members
		t.grossIncome = 50000;
		t.dependents = 2;
		t.state = "NJ";
		double yourTax = t.adjustForStudents(t.calcTaX()); //calculates tax
		//Print the results
		System.out.println("Your tax is " + yourTax);
	}
}