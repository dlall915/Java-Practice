package com.practicaljava.lesson08;

import javax.swing.JFrame;
import javax.swing.JButton;

/**
 * A simple JFrame with a single button. The button takes up the entire frame
 * since there is no layout.
 * 
 * @author David Lall
 *
 */

public class HelloWorld extends JFrame {
	public static void main (String[] args) {
		JFrame myWindow = new HelloWorld();
		
		// creating and adding a button to the container
		JButton myButton = new JButton ("Click me");
		myWindow.add(myButton);
		myWindow.setSize(200, 300);
		myWindow.setTitle("Hello World");
		myWindow.setVisible(true);
		myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}