package com.qa.ims.project2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.LocalTime;

public class Store {
	
	DBconfig ims = new DBconfig();
	
	Connection conn = ims.connectDB();

	PreparedStatement preState;
	
	LocalDate myDate = LocalDate.now();
	LocalTime myTime = LocalTime.now();
	
	public boolean addItem(Items item) {
		
		try {
			String query = "INSERT INTO items (price, category, product) VALUES (?,?,?);";
			preState = conn.prepareStatement(query);

			preState.setFloat(1, item.getPrice());
			preState.setString(2, item.getCategory());
			preState.setString(3, item.getProduct());
	
			preState.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public ArrayList<Items> viewAllItems() {
		
		ArrayList<Items> itemsList = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM items;";
			preState = conn.prepareStatement(query);
			ResultSet result = preState.executeQuery();

			while (result.next()) {
				
				Items newItem = convertResultsItem(result);
				
				itemsList.add(newItem); 
			}
			
			return itemsList;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public boolean updateItem(Items item, int id) {
		
		try {
			
			String query = "UPDATE items SET price = ?, category = ?, product = ? WHERE item_id = ?;";
			preState = conn.prepareStatement(query);

			preState.setFloat(1, item.getPrice());
			preState.setString(2, item.getCategory());
			preState.setString(3, item.getProduct());
			preState.setInt(4, id);
			preState.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean deleteItemById(int id) {
		
		try {
			String query = "DELETE FROM items WHERE item_id = ?";
			preState = conn.prepareStatement(query);
			
			preState.setInt(1, id); 
			preState.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean addCust(Customers cust) {
		
		try {
			String query = "INSERT INTO customers (forename, surname, email, phone) VALUES (?,?,?,?);";
			preState = conn.prepareStatement(query);

			preState.setString(1, cust.getForename());
			preState.setString(2, cust.getSurname());
			preState.setString(3, cust.getEmail());
			preState.setString(4, cust.getPhone());
			
			preState.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public ArrayList<Customers> viewAllCust() {
		
		ArrayList<Customers> custList = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM customers;";
			preState = conn.prepareStatement(query);
			ResultSet result = preState.executeQuery();

			while (result.next()) {
				
				Customers newCust = convertResultsCust(result);
				
				custList.add(newCust);
			}
			
			return custList;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public boolean updateCust(Customers cust, int id) {
		
		try {
			
			String query = "UPDATE customers SET forename = ?, surname = ?, email = ?, phone = ? WHERE cust_id = ?;";
			preState = conn.prepareStatement(query);

			preState.setString(1, cust.getForename());
			preState.setString(2, cust.getSurname());
			preState.setString(3, cust.getEmail());
			preState.setString(4, cust.getPhone());
			preState.setInt(5, id);
			preState.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public boolean deleteCustById(int id) {
		
		try {
			String query = "DELETE FROM customers WHERE cust_id = ?";
			preState = conn.prepareStatement(query);
			
			preState.setInt(1, id); 
			preState.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Items convertResultsItem(ResultSet result) {
		
		try {
			int item_id = result.getInt("item_id");
			float price = result.getFloat("price");
			String category = result.getString("category");
			String product = result.getString("product");
			
			return new Items(item_id, price, category, product);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public Customers convertResultsCust(ResultSet result) {
		
		try {
			int cust_id = result.getInt("cust_id");
			String forename = result.getString("forename");
			String surname = result.getString("surname");
			String email = result.getString("email");
			String phone = result.getString("phone");
			
			return new Customers(cust_id, forename, surname, email, phone);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
}
