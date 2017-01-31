package com.practicaljava.lesson08;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.practicaljava.lesson09.*;

/**
 * A calculator interface that uses BorderLayout and GridLayout.
 * 
 * @author David Lall
 *
 */

public class Calculator {
	// declare all calculator's components
	JPanel windowContent;
	private JTextField displayField;
	JButton button0;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JButton button8;
	JButton button9;
	JButton buttonPoint;
	JButton buttonClear;
	JButton buttonEqual;
	JButton buttonAdd;
	JButton buttonSub;
	JPanel p1;
	
	// constructor creates the components and adds them to the frame using
	// combination of Borderlayout and Gridlayout
	Calculator() {
		windowContent = new JPanel();
		// set the layout manager for this panel
		BorderLayout bl = new BorderLayout();
		windowContent.setLayout(bl);
		// create the display field and place it in the North area 
		// of the window
		displayField = new JTextField(30);
		displayField.setText("0");
		windowContent.add("North", displayField);
		// create buttons using constructor of the class JButton that takes
		// the label of the button as a parameter
		button0 = new JButton("0");
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonPoint = new JButton(".");
		buttonClear = new JButton("C");
		buttonEqual = new JButton("=");
		buttonAdd = new JButton("+");
		buttonSub = new JButton("-");
		// create the panel with the GridLayout with 12 buttons - 
		// 10 numeric ones, period, and the equal sign
		p1 = new JPanel();
		GridLayout gl = new GridLayout(5, 3);
		p1.setLayout(gl);
		// add window controls to the panel p1
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		p1.add(button4);
		p1.add(button5);
		p1.add(button6);
		p1.add(button7);
		p1.add(button8);
		p1.add(button9);
		p1.add(button0);
		p1.add(buttonPoint);
		p1.add(buttonClear);
		p1.add(buttonAdd);
		p1.add(buttonSub);
		p1.add(buttonEqual);
		// add the panel p1 to the center of the window
		windowContent.add("Center", p1);
		// create the frame and set its content pane
		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(windowContent);
		// set the size of the window big enough to accommodate all controls
		frame.pack();
		// display the window
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set the behavior for the buttons
		CalculatorEngine calcEngine = new CalculatorEngine(this);
		button0.addActionListener(calcEngine);
		button1.addActionListener(calcEngine);
		button2.addActionListener(calcEngine);
		button3.addActionListener(calcEngine);
		button4.addActionListener(calcEngine);
		button5.addActionListener(calcEngine);
		button6.addActionListener(calcEngine);
		button7.addActionListener(calcEngine);
		button8.addActionListener(calcEngine);
		button9.addActionListener(calcEngine);
		buttonPoint.addActionListener(calcEngine);
		buttonClear.addActionListener(calcEngine);
		buttonEqual.addActionListener(calcEngine);
		buttonAdd.addActionListener(calcEngine);
		buttonSub.addActionListener(calcEngine);
	}
	
	public void setDisplayValue(String val) {
		displayField.setText(val);
	}
	
	public String getDisplayValue() {
		return displayField.getText();
	}
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
}