package com.practicaljava.lesson10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The controller for the bicycle ordering interface.
 * 
 * @author David Lall
 *
 */

public class BikeOrderEngine implements ActionListener {
	private BikeOrderInterface parent;
	private String quantityString;
	private int quantityInt;
	
	 /**
	  * Constructor stores the reference to the bike ordering window in the
	  * member variable parent
	  * 
	  * @param parent
	  */
	public BikeOrderEngine(BikeOrderInterface parent) {
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			quantityString = parent.getQuantity();
			quantityInt = Integer.parseInt(quantityString);
			validateOrder(quantityString, quantityInt);
		} catch (TooManyBikesException e1) {
			System.out.println(e1.getMessage());
		}
	}
	
	private void validateOrder(String quantityString, int quantityInt) 
			throws TooManyBikesException {
		if (quantityInt > 5) {
			throw new TooManyBikesException("Cannot order " + quantityString +
					" " + parent.getSelectedModel() + 
					" model bikes, please select " + "a lower quantity.");
		}
		else {
			System.out.println("Your order of " + quantityString + " " +
					parent.getSelectedModel() + " model bikes has been "
					+ "placed.");
		}
	}
}