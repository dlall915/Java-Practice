package com.practicaljava.lesson09;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.practicaljava.lesson08.Calculator;

/**
 * The controller for the Calculator in lesson 8.
 * 
 * @author David Lall
 *
 */

public class CalculatorEngine implements ActionListener {
	private Calculator parent; // a reference to the Calculator
	private String temp = null;
	private String firstNum = null;
	private String secondNum = null;
	private String result = "0";
	private boolean adding = false;
	private boolean subtracting = false;
	
	 /**
	  * Constructor stores the reference to the Calculator window in the
	  * member variable parent
	  * @param parent
	  */
	public CalculatorEngine(Calculator parent) {
		this.parent = parent;
	}
	
	/**
	 * Displays the button selected on the display of the calculator.
	 */
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = null;
		// get the source object of this action
		Object src = e.getSource();
		// check which button was selected
		clickedButton = (JButton)src;
		// get the button's label
		String clickedButtonLabel = clickedButton.getText();
		if (clickedButtonLabel == "=") {
			calcResult(temp);
		}
		else if (clickedButtonLabel == "C") {
			clearCalc();
		}
		else if (clickedButtonLabel == "+") {
			addNum(temp);
		}
		else if (clickedButtonLabel == "-") {
			subNum(temp);
		}
		else {
			createNum(clickedButtonLabel);
		}
	}
	
	private void createNum(String clickedButtonLabel) {
		checkNull(clickedButtonLabel);
	}
	
	private void checkNull(String num) {
		if (temp == null) {
			temp = num;
		}
		else {
			temp = temp + num;
		}
		parent.setDisplayValue(temp);
	}
	
	private void clearCalc() {
		temp = null;
		firstNum = null;
		secondNum = null;
		result = "0";
		adding = false;
		subtracting = false;
		parent.setDisplayValue("0");
	}
	
	private void addNum(String num) {
		adding = true;
		firstNum = num;
		temp = null;
	}
	
	private void subNum(String num) {
		subtracting = true;
		firstNum = num;
		temp = null;
	}
	
	private void calcResult(String num) {
		secondNum = num;
		int firstNumInt = Integer.parseInt(firstNum);
		int secondNumInt = Integer.parseInt(secondNum);
		int resultInt = 0;
		if (adding == true) {
			resultInt = firstNumInt + secondNumInt;
		}
		else if (subtracting = true) {
			resultInt = firstNumInt - secondNumInt;
		}
		result = Integer.toString(resultInt);
		parent.setDisplayValue(result);
	}	
}