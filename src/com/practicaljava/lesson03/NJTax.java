package com.practicaljava.lesson03;

class NJTax extends Tax {
	double adjustForStudents(double stateTax) {
		double adjustedTax = stateTax - 500;
		return adjustedTax;
	}
}