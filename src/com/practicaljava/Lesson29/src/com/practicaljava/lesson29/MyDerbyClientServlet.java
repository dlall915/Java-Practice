package com.practicaljava.lesson29;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/MyDerbyClientServlet")
public class MyDerbyClientServlet extends HttpServlet {
	
	@Resource(name="java:global/DerbyPool")
	DataSource ds;
	
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection myPooledConnection = ds.getConnection();
			System.out.println("Got pooled connection to DerbyDB");
			getDatabase();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void getDatabase() {
		String sqlQuery = "SELECT * from Employee";
		// open autoclosesable Connection, Statement and get the result set
		try (Connection conn = DriverManager.getConnection(
				"jdbc:derby://localhost:1527/Lesson29");
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