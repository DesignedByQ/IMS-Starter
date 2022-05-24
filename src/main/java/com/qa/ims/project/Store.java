package com.qa.ims.project;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Store {
	
	DBconfig ims = new DBconfig();
	
	Connection conn = ims.connectDB();

	PreparedStatement preState;
	
	public boolean addItem(Items item) {
		
		try {
			String query = "INSERT INTO items (price, category, type, adult_restricted, stock) VALUES (?,?,?,?,?);";
			preState = conn.prepareStatement(query);

			preState.setFloat(1, item.getPrice());
			preState.setString(2, item.getCategory());
			preState.setString(3, item.getType());
			preState.setBoolean(4, item.isAdultRes());
			preState.setInt(5, item.getStock());
			preState.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
