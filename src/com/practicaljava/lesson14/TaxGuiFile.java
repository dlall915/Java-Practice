package com.practicaljava.lesson14;

import com.practicaljava.lesson05.Tax;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * A tax GUI that retrieves the sates from a text file.
 * 
 * @author David Lall
 *
 */

@SuppressWarnings("serial")
public class TaxGuiFile extends JFrame {
	JLabel lblGrIncome;
	JTextField txtGrossIncome = new JTextField(15);
	JLabel lblDependents = new JLabel(" Number of Dependents:");
	JTextField txtDependents = new JTextField(2);
	JLabel lblState = new JLabel(" State:");
	
	// define a data model for the ComboBox chState
	Vector<String> states = new Vector<>(51);
	
	// create a ComboBox to get data from the model
	JComboBox<String> chState = new JComboBox<>(states);
	JLabel lblTax = new JLabel(" State Tax: ");
	JTextField txtStateTax = new JTextField(10);
	JButton bGo = new JButton("Go");
	JButton bReset = new JButton("Reset");
	
	TaxGuiFile() {
		lblGrIncome = new JLabel("Gross Income: ");
		GridLayout gr = new GridLayout(5,2,1,1);
		setLayout(gr);
		add(lblGrIncome);
		add(txtGrossIncome);
		add(lblDependents);
		add(txtDependents);
		add(lblState);
		add(chState);
		add(lblTax);
		add(txtStateTax);
		add(bGo);
		add(bReset);
		// populate states from a text file
		populateStates();
		
		chState.setSelectedIndex(0);
		txtStateTax.setEditable(false);
		
		// the button, bGo, processing using lambda expression
		bGo.addActionListener(evt -> {
			try {
				int grossInc = Integer.parseInt(txtGrossIncome.getText());
				int dependents = Integer.parseInt(txtDependents.getText());
				String state = (String)chState.getSelectedItem();
				Tax tax = new Tax(grossInc, state, dependents);
				String sTax = Double.toString(tax.calcTax());
				txtStateTax.setText(sTax);
			}
			catch(NumberFormatException e) {
				txtStateTax.setText("Non-Numeric Data");
			}
			catch (Exception e) {
				txtStateTax.setText(e.getMessage());
			}
		});
		
		// the button, bReset, processing using lambda expression
		bReset.addActionListener(evt -> {
			txtGrossIncome.setText("");
			txtDependents.setText("");
			chState.setSelectedIndex(0);
			txtStateTax.setText("");
		});
		
		// define, instantiate and register a WindowAdapater to process
		// windowClosing Event of this frame
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	/**
	 * Populates the state ComboBox using the states.txt file.
	 */
	private void populateStates() {
		states.add("Select State");
		try (
			FileInputStream myFile = new FileInputStream("H:\\Google Drive\\Programming\\Eclipse\\workspace\\JavaPractice3\\src\\com\\practicaljava\\lesson14\\states.txt");
			InputStreamReader inputStreamReader = 
					new InputStreamReader(myFile, "UTF8");
			BufferedReader reader = new BufferedReader(inputStreamReader);) {
			String stateName;
			while ((stateName = reader.readLine()) != null) {
				states.add(stateName);
			}
		}
		catch (IOException ioe) {
			txtStateTax.setText("Can't read states.txt: " + ioe.getMessage());
		}
	}
	
	public static void main (String[] args) {
		TaxGuiFile taxFrame = new TaxGuiFile();
		taxFrame.setSize(400,150);
		taxFrame.setVisible(true);
	}
}