package com.practicaljava.lesson03;

/**
 * Class for calculating taxes.
 * 
 * @author David Lall
 */

class Tax {
	double grossIncome;
	String state;
	int dependents;
	/**
	 * Returns one of two calculations for taxes depending on whether
	 * grossIncome is above of below 30000.
	 */
	public double calcTaX() {
		double stateTax = 0;
		if (grossIncome < 30000) {
			stateTax = grossIncome*0.05;
		}
		else {
			stateTax = grossIncome*0.06;
		}
		return stateTax;
	}
}