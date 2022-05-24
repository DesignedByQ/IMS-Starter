package com.qa.ims.project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconfig {
	
	final String TEST_DB_URL = "jdbc:mysql://localhost:3306/test_ims_db";
	
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost:3306/ims_db";
	final String USER = "root";
	final String PASSWORD = "root";

	Connection conn;

	public Connection connectDB() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(TEST_DB_URL, USER, PASSWORD);
			System.out.println("Connected to Database!");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return conn;

	}


}
