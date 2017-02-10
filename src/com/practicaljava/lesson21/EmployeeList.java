package com.practicaljava.lesson21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Retrieves data from a database created locally, derbyclient.jar must be 
 * added in run configuration or added directly to the project.
 * 
 * @author David Lall
 *
 */

class EmployeeList {
	public static void main (String[] args) {
		String sqlQuery = "SELECT * from Employee";
		// open autoclosesable Connection, Statement and get the result set
		try (Connection conn = DriverManager.getConnection(
				"jdbc:derby://localhost:1527/Lesson21");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlQuery);) {
			// process each column in the result set and print the data
			while (rs.next()) {
				// if names of columns aren't known, positions can be used
				// starting from 1, ex. rs.getInt(1);
				int empNo = rs.getInt("EMPNO");
				String eName = rs.getString("ENAME");
				String job = rs.getString("JOB_TITLE");
				System.out.println("" + empNo + ", " + eName + ", " + job);
			}
		}
		catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " +
					se.getErrorCode());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}