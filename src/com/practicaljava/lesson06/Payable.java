package com.practicaljava.lesson06;

/**
 * Interface for implementing pay raises.
 * 
 * @author David Lall
 */

public interface Payable {
	final int INCREASE_CAP = 20;
	boolean increasePay(int percent);
}