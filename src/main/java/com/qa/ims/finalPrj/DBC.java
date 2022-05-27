package com.qa.ims.finalPrj;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBC {
	
	//final means the variable can never be changed
	final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; //Where are jdbc driver is
	final String DB_URL = "jdbc:mysql://localhost:3306/ims_db";
	final String USER = "root";
	final String PASSWORD = "root";  
	
	//import connection from java.sql
	Connection conn;
	
	//This method is for connecting to our db 
	public Connection connect() {
		
		try {
			Class.forName(JDBC_DRIVER); //finding our JDBC driver to use
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD); //connects to the online and enters user and pw
			System.out.println("Connected!");
		} catch(Exception e){
			e.printStackTrace();
			
		}
		return conn; //return the connection we have created
	}
		
}
