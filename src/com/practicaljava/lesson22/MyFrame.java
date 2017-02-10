package com.practicaljava.lesson22;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * Shows tabular data graphically using a JFrame with JTable.
 * Quantity column of the data is editable and the database is updated if
 * values are changed.
 * 
 * @version 0.5 02/10/17
 * @author David Lall
 */

public class MyFrame extends JFrame implements TableModelListener {
	private static final long serialVersionUID = 1L;
	private MyTableModel myTableModel;
	private JTable myTable;
	
	MyFrame (String winTitle) {
		super(winTitle);
		myTableModel = new MyTableModel();
		myTable = new JTable(myTableModel);
		// add the JTable to fram and enable scrolling
		add(new JScrollPane(myTable));
		// register an event listener
		myTableModel.addTableModelListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void tableChanged(TableModelEvent e) {
		System.out.println("Someone modified the data in JTable!");
		Connection conn = null;
		Statement stmt = null;
		String query;
		// updates the changed quantity
		try {
			conn = DriverManager.getConnection(
				"jdbc:derby://localhost:1527/Lesson21");
			stmt = conn.createStatement();
			query = "UPDATE Portfolio SET quantity=" + 
					myTableModel.getValueAt(e.getFirstRow(), e.getColumn()) +
					" WHERE id=" + (e.getFirstRow() + 1);
			System.out.println(query);
			stmt.executeUpdate(query);
		}
		catch (SQLException se) {
			System.out.println("SQL Error: " + se.getMessage() +
					           ", the db error code is " + se.getErrorCode());
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyFrame myFrame = new MyFrame("My Test Window");
		myFrame.pack();
		myFrame.setVisible(true);
	}
	
	class MyTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		ArrayList<Order> myData = new ArrayList<>();
		String[] orderColNames = { "Order ID", "Symbol", "Quantity", "Price"};
		
		// populate the JTable from the database
		MyTableModel() {
			String sqlQuery = "Select * from Portfolio";
			
			try (Connection conn = DriverManager.getConnection( 
	                "jdbc:derby://localhost:1527/Lesson21");
	             Statement stmt = conn.createStatement(); 
	             ResultSet rs = stmt.executeQuery(sqlQuery);){
				Integer id = 1;
				while (rs.next()) {
					String symbol = rs.getString(2);
					Integer quantity = rs.getInt(3);
					Float price = rs.getFloat(4);
					myData.add(new Order(id,symbol,quantity,price));
					id++;
				}
			} 
			catch (SQLException se) {
				System.out.println("SQL Error: " + se.getMessage() +
						", the db error code is " + se.getErrorCode());
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public String getColumnName(int col) {
			return orderColNames[col];
		}
		
		public int getColumnCount() {
			return 4;
		}
		
		public int getRowCount() {
			return myData.size();
		}
		
		public Object getValueAt(int row, int col) {
			switch (col) {
				case 0:// column 1
					return myData.get(row).orderID;
				case 1:
					return myData.get(row).stockSymbol;
				case 2:
					return myData.get(row).quantity;
				case 3:
					return myData.get(row).price;
				default:
					return "";
			}
		}
		
		// allows user to change the quantity of the stock
		public boolean isCellEditable(int row, int col) {
			if (col == 2) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// allows user to change the quantity of the stock
		public void setValueAt(Object value, int row, int col) {
			if (col == 2) {
				myData.get(row).quantity = (Integer.valueOf(value.toString()));
			}
			// notify listeners about the data change
			TableModelEvent event = new TableModelEvent(this,row,row,col);
			fireTableChanged(event);
		}
	}
}