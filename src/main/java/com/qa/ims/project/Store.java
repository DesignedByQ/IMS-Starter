package com.qa.ims.project;

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
	
	public boolean createOrder() {
		//find the latest cutomer and set theyre cust id to a variable in here
		//get cust by id then access the id to use here
		try {
			String query1 = "SELECT * FROM customers ORDER BY customer_id DESC LIMIT 1;";
			preState = conn.prepareStatement(query1);
			
			ResultSet result = preState.executeQuery();
			
			result.next();
			int custID = convertResultsCust(result).getCustId();
			//System.out.println(custID);
			
			
			String query = "INSERT INTO live_orders (fk_customer_id, fk_item_id, price, category, type, adult_restricted, stock, date_placed, time_placed) VALUES (?,?,?,?,?,?,?,?,?);";
			preState = conn.prepareStatement(query);
			
			preState.setInt(1, custID);
			preState.setInt(2, 3); //how do i set this to null
			preState.setFloat(3, 0);
			preState.setString(4, "");
			preState.setString(5, "");
			preState.setBoolean(6, true);
			preState.setInt(7, 0);
			preState.setDate(8, java.sql.Date.valueOf(myDate));
			preState.setTime(9, java.sql.Time.valueOf(myTime));
			

			preState.executeUpdate();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	private ArrayList<Items> orderBasket = new ArrayList<Items>();
	
	public ArrayList<Items> addItemToOrder(int id) {
		
		try {
			//get the latest cust added and retrieve their id
			String query = "SELECT * FROM customers ORDER BY customer_id DESC LIMIT 1;";
			preState = conn.prepareStatement(query);
			
			ResultSet result = preState.executeQuery();
			
			result.next();
			int custID = convertResultsCust(result).getCustId();
			
			//select from the item inventory where the type == to the para.item 
			//String query1 = "SELECT * FROM items WHERE type = " + item.getType();
			String query1 = "SELECT * FROM items WHERE item_id = ?";
			preState = conn.prepareStatement(query1);
			preState.setInt(1, id);
			
			ResultSet result1 = preState.executeQuery();
			
			if (result1.next()) {
				String query2 = "INSERT INTO live_orders (fk_customer_id, fk_item_id, price, category, type, adult_restricted, stock, date_placed, time_placed) VALUES (?,?,?,?,?,?,?,?,?);";
				preState = conn.prepareStatement(query2);
				
				Items insertedItem = convertResultsItem(result1);
				
				preState.setInt(1, custID);
				preState.setInt(2, insertedItem.getItemId());
				preState.setFloat(3, insertedItem.getPrice());
				preState.setString(4, insertedItem.getCategory());
				preState.setString(5, insertedItem.getType());
				preState.setBoolean(6, insertedItem.isAdultRes());
				preState.setInt(7, insertedItem.getStock());
				preState.setDate(8, java.sql.Date.valueOf(myDate));
				preState.setTime(9, java.sql.Time.valueOf(myTime));
				preState.executeUpdate();
								
				String query3 = "SELECT * FROM live_orders;";
				preState = conn.prepareStatement(query3);
				ResultSet ordered = preState.executeQuery();

				while (ordered.next()) {
					
					Items newItem = convertResultsItem(ordered);
					
					orderBasket.add(newItem);
				}
				
			} 
			
			return orderBasket;	
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
	
	public Orders convertResultsOrd(ResultSet result) {
		
		try {
			int order_id = result.getInt("order_id");
			int fk_customer_id = result.getInt("fk_customer_id");
			int items_qty = result.getInt("items_qty");
			float total = result.getFloat("total");
			Date date_placed = result.getDate("date_placed");
			Time time_placed = result.getTime("time_placed");
			
			return new Orders(order_id, fk_customer_id, items_qty, total, date_placed, time_placed);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
