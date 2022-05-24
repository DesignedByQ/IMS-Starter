package com.qa.ims.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			//if (getItems(id)) {} else
			String query = "UPDATE items SET price = ?, category = ?, type = ?, adult_restricted = ?, stock = ? WHERE item_id = ?";
			preState = conn.prepareStatement(query);

			preState.setFloat(1, item.getPrice());
			preState.setString(2, item.getCategory());
			preState.setString(3, item.getType());
			preState.setBoolean(4, item.isAdultRes());
			preState.setInt(5, item.getStock());
			preState.setInt(6, id);
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
	
	public ArrayList<Customers> viewAllCustomers() {
		
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
	
	public boolean updateCustomer(Customers cust, int id) {
		
		try {
			//if (getItems(id)) {} else
			String query = "UPDATE customers SET forename = ?, surname = ?, email = ?, phone = ? WHERE customer_id = ?";
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
	
	public boolean deleteCustomerById(int id) {
		
		try {
			String query = "DELETE FROM customers WHERE customer_id = ?";
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
			int price = result.getInt("price");
			String category = result.getString("category");
			String type = result.getString("type");
			boolean adult_restricted = result.getBoolean("adult_restricted");
			int stock = result.getInt("stock");

			return new Items(item_id, price, category, type, adult_restricted, stock);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public Customers convertResultsCust(ResultSet result) {
		
		try {
			int customer_id = result.getInt("customer_id");
			String forename = result.getString("forename");
			String surname = result.getString("surname");
			String email = result.getString("email");
			String phone = result.getString("phone");
			
			return new Customers(customer_id, forename, surname, email, phone);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
