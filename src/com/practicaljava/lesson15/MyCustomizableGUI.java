package com.practicaljava.lesson15;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * A GUI with a a pop up preferences window for options to change the window
 * color, font, and font size. The preferences are serialized and loaded when
 * the GUI is started.
 * 
 * @author David Lall
 *
 */

public class MyCustomizableGUI extends JFrame {
	private static final long serialVersionUID = 1L;
	String color;
	String font;
	int fontSize;
	
	JLabel lblTxtField = new JLabel("Type to test preferences:");
	JTextField txtField = new JTextField(15);
	JButton bPreferences = new JButton("Preferences");
	
	// data models for the ComboBoxes
	Vector<String> colors = new Vector<>(5);
	Vector<String> fonts = new Vector<>(5);
	Vector<String> fontSizes = new Vector<>(11);
	
	// maps the color selected since Color cannot work with Strings
	HashMap<String, Color> colorMap = new HashMap<String, Color>();	
	
	// a new window for preferences
	JDialog dPreferences = new JDialog (this, "Preferences");
	JLabel lblColor = new JLabel("Background color:");
	JComboBox<String> chColor = new JComboBox<>(colors);
	JLabel lblFont = new JLabel("Font:");
	JComboBox<String> chFont = new JComboBox<>(fonts);
	JLabel lblFontSize = new JLabel("Font size:");
	JComboBox<String> chFontSize = new JComboBox<>(fontSizes);
	JButton bSave = new JButton("Save");
	JButton bCancel = new JButton("Cancel");
	
	MyCustomizableGUI() {
		GridLayout gr = new GridLayout(2,2,5,1);
		setLayout(gr);
		add(lblTxtField);
		add(txtField);
		add(bPreferences);
		
		// populate color hashmap
		colorMap.put("white", Color.WHITE);
		colorMap.put("red", Color.RED);
		colorMap.put("blue", Color.BLUE);
		colorMap.put("green", Color.GREEN);
		
		getPreferences();
		
		this.getContentPane().setBackground(colorMap.get(color));
		Font f = new Font(font, Font.PLAIN, fontSize);
		txtField.setFont(f);
		
		// populate Vectors from files
		populatePreferences();
		
		chColor.setSelectedIndex(0);
		chFont.setSelectedIndex(0);
		chFontSize.setSelectedIndex(0);
		
		// the button, bPreferences, processing using lambda expression
		bPreferences.addActionListener(evt -> {
			GridLayout grd = new GridLayout(4,2,10,5);
			dPreferences.getContentPane().setBackground(colorMap.get(color));
			dPreferences.setLayout(grd);
			dPreferences.add(lblColor);
			dPreferences.add(chColor);
			dPreferences.add(lblFont);
			dPreferences.add(chFont);
			dPreferences.add(lblFontSize);
			dPreferences.add(chFontSize);
			dPreferences.add(bSave);
			dPreferences.add(bCancel);
			dPreferences.pack();
			dPreferences.setResizable(false);
			dPreferences.setVisible(true);
		});
		
		// the button, bSave, processing using lambda expression
		bSave.addActionListener(evt -> {
			try {
				color = (String)chColor.getSelectedItem();
				font = (String)chFont.getSelectedItem();
				fontSize = Integer.parseInt((String) chFontSize.getSelectedItem());
			}
			catch(NumberFormatException e) {
				System.out.println("Non-Numeric Data");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			UserPreferences prefs = new UserPreferences(color, font, fontSize);
			try (FileOutputStream fOut = new FileOutputStream("preferences.ser");
					ObjectOutputStream oOut = new ObjectOutputStream(fOut);) {
				oOut.writeObject(prefs); // serializing UserPreferences
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
			System.out.println(
					"UserPreferences object has been serialized into preferences.ser");
			dPreferences.dispose();
		});
		
		// the button, bCancel, processing using lambda expression
		bCancel.addActionListener(evt -> {
			dPreferences.dispose();
		});
		
		// define, instantiate and register a WindowAdapater to process
		// windowClosing Event of this frame
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void getPreferences() {
		UserPreferences prefs = null;
		try (FileInputStream fileIn = new FileInputStream("preferences.ser");
				ObjectInputStream objectIn = new ObjectInputStream(fileIn);) {
			prefs = (UserPreferences)objectIn.readObject();
			color = prefs.getColor();
			font = prefs.getFont();
			fontSize = prefs.getFontSize();
		}
		catch (FileNotFoundException fnf) {
			color = "white";
			font = "Arial";
			fontSize = 14;
		}
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Populates the state ComboBox using the states.txt file.
	 */
	private void populatePreferences() {
		colors.add("Select color");
		fonts.add("Select font");
		fontSizes.add("Select font size");
		
		try (
			FileInputStream myFile = new FileInputStream("H:\\Google Drive\\Programming\\Eclipse\\workspace\\JavaPractice3\\src\\com\\practicaljava\\lesson15\\Colors.txt");
			InputStreamReader inputStreamReader = 
					new InputStreamReader(myFile, "UTF8");
			BufferedReader reader = new BufferedReader(inputStreamReader);) {
			String colorName;
			while ((colorName = reader.readLine()) != null) {
				colors.add(colorName);
			}
		}
		catch (IOException ioe) {
			System.out.println("Can't read Colors.txt: " + ioe.getMessage());
		}
		
		try (
				FileInputStream myFile = new FileInputStream("H:\\Google Drive\\Programming\\Eclipse\\workspace\\JavaPractice3\\src\\com\\practicaljava\\lesson15\\Fonts.txt");
				InputStreamReader inputStreamReader = 
						new InputStreamReader(myFile, "UTF8");
				BufferedReader reader = new BufferedReader(inputStreamReader);) {
				String fontName;
				while ((fontName = reader.readLine()) != null) {
					fonts.add(fontName);
				}
			}
			catch (IOException ioe) {
				System.out.println("Can't read Fonts.txt: " + ioe.getMessage());
			}
		
		try (
				FileInputStream myFile = new FileInputStream("H:\\Google Drive\\Programming\\Eclipse\\workspace\\JavaPractice3\\src\\com\\practicaljava\\lesson15\\FontSizes.txt");
				InputStreamReader inputStreamReader = 
						new InputStreamReader(myFile, "UTF8");
				BufferedReader reader = new BufferedReader(inputStreamReader);) {
				String fontSize;
				while ((fontSize = reader.readLine()) != null) {
					fontSizes.add(fontSize);
				}
			}
			catch (IOException ioe) {
				System.out.println("Can't read FontSizes.txt: " + ioe.getMessage());
			}
	}
	
	public static void main (String[] args) {
		MyCustomizableGUI customFrame = new MyCustomizableGUI();
		customFrame.setSize(400,150);
		customFrame.pack();
		customFrame.setVisible(true);
	}
}