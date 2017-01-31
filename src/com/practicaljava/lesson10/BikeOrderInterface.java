package com.practicaljava.lesson10;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Interface for ordering bicycles.
 * 
 * @author David Lall
 *
 */

public class BikeOrderInterface {
	private JPanel windowContent;
	private JComboBox<String> modelList;
	private JTextField quantity;
	private JButton orderButton;
	
	BikeOrderInterface() {
		windowContent = new JPanel();
		// set the layout manager for this panel
		FlowLayout fl = new FlowLayout();
		windowContent.setLayout(fl);
		quantity = new JTextField(30);
		resetQuantity();
		String[] bikeModels = {"Pinarello", "BMC", "Raleigh", "Jamis", "Fuji"};
		modelList = new JComboBox<String>(bikeModels);
		orderButton = new JButton("Order");
		// add all the components to the JPanel
		windowContent.add(quantity);
		windowContent.add(modelList);
		windowContent.add(orderButton);
		// create the frame and set its content pane
		JFrame frame = new JFrame("Order a bike!");
		frame.setContentPane(windowContent);
		// set the size of the window big enough to accommodate all controls
		frame.pack();
		// display the window
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set the behavior for the buttons
		BikeOrderEngine bikeEngine = new BikeOrderEngine(this);
		orderButton.addActionListener(bikeEngine);
	}
	
	public String getQuantity() {
		return quantity.getText();
	}
	
	public void resetQuantity() {
		quantity.setText("0");
	}
	
	public Object getSelectedModel() {
		return modelList.getSelectedItem();
	}
	
	public static void main (String[] args) {
		@SuppressWarnings("unused")
		BikeOrderInterface bikes = new BikeOrderInterface();
	}
}