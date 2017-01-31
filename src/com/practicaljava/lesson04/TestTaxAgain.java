package com.practicaljava.lesson04;

/**
 * Test for the Tax class.
 * 
 * @author David Lall
 */

class TestTax {
	public static void main (String[] args) {
		Tax t1 = new Tax(65000, "TX", 4);
		double hisTax = t1.calcTax();
		System.out.println("His tax in dollars: " + hisTax);
		Tax.convertToEuros(hisTax);
		
		Tax t2 = new Tax(50000, "NY", 0);
		double herTax = t2.calcTax();
		System.out.println("Her tax in dollars: " + herTax);
		Tax.convertToEuros(herTax);
	}
}