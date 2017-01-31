package com.practicaljava.lesson04;

/**
 * Class for calculating taxes.
 * 
 * @author David Lall
 */

class Tax {
	static int customerCounter = 0;
	double grossIncome;
	String state;
	int dependents;
	
	/**
	 * Sets the gross income, state, and dependents and increments the 
	 * customer count by one.
	 * 
	 * @param grossIncome
	 * 		Gross income.
	 * @param state
	 * 		State.
	 * @param dependents
	 * 		Dependents.
	 */
	Tax (double grossIncome, String state, int dependents) {
		this.grossIncome = grossIncome;
		this.state = state;
		this.dependents = dependents;
		System.out.println("Preparing the tax data for customer #" + 
				customerCounter);
	}
	
	/**
	 * Returns the tax by multiplying the gross income by 0.33 and deducting
	 * the number of dependents multiplied by one hundred.
	 */
	public double calcTax() {
		return (grossIncome * 0.33 - dependents * 100);
	}
	
	/**
	 * Returns a given tax amount in dollars to euros.
	 * 
	 * @param taxInDollars
	 * 		Tax amount in dollars.
	 */
	public static void convertToEuros(double taxInDollars) {
		System.out.println("Tax in Euros: " + taxInDollars / 1.25);
	}
}