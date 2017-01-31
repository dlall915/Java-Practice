package com.practicaljava.lesson05;

/**
 * Test for the Tax class.
 * 
 * @author David Lall
 */

class TestTax {
	public static void main (String[] args) {
		if (args.length != 3) {
			System.out.println("Sample usage of the program: " + 
					"java TestTaxCmd 50000 NJ 2");
			System.exit(0);
		}
		
		double grossIncome = Double.parseDouble(args[0]);
		String state = args[1];
		int dependents = Integer.parseInt(args[2]);
		
		Tax t1 = new Tax(grossIncome, state, dependents);
		double hisTax = t1.calcTax();
		System.out.println("His tax in dollars: " + hisTax);
		Tax.convertToEuros(hisTax);
	}
}