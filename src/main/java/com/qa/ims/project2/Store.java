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
	
	public boolean createOrder() {
		//find the latest customer and set they're cust id to a variable in here
		
		try {
			String query = "SELECT * FROM customers ORDER BY cust_id DESC LIMIT 1;";
			preState = conn.prepareStatement(query);
			
			ResultSet result = preState.executeQuery();
			
			result.next();
			int custID = convertResultsCust(result).getCust_id();
			
			//set up the new or with cust id and default values
			String query1 = "INSERT INTO orders (fk_cust_id, total, dated, timed) VALUES (?,?,?,?);";
			preState = conn.prepareStatement(query1);
			
			preState.setInt(1, custID);
			preState.setInt(2, 0); 
			preState.setDate(3, java.sql.Date.valueOf(myDate));
			preState.setTime(4, java.sql.Time.valueOf(myTime));
			
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
			//get the latest order added and retrieve the id
			String query = "SELECT * FROM orders ORDER BY order_id DESC LIMIT 1;";
			preState = conn.prepareStatement(query);
			
			ResultSet result = preState.executeQuery();
			
			result.next();
			int ordID = convertResultsOrd(result).getOrder_id();
			
//			//get the item id of the selcted product
//			String query9 = "SELECT * FROM orders ORDER BY order_id DESC LIMIT 1;";
//			preState = conn.prepareStatement(query9);
//			
//			ResultSet result3 = preState.executeQuery();
//			
//			result.next();
//			int itemID = convertResultsItem(result3).getItem_id();
			
			//select from the item inventory where the type == to the para.item ie get item by type
			String query1 = "SELECT * FROM items WHERE item_id = (?)";
			preState = conn.prepareStatement(query1);
			preState.setInt(1, id);
			
			ResultSet result1 = preState.executeQuery();
			System.out.println(result1.next());
			//System.out.println(result1);	
			
			int itemID = convertResultsItem(result1).getItem_id();
			//System.out.println(itemID);
			
			//if (true) {
				String query2 = "INSERT INTO pos (fk_ord_id, fk_item_id, price, category, product) VALUES (?,?,?,?,?);";
				preState = conn.prepareStatement(query2);
				
				Items insertedItem = convertResultsItem(result1);
				System.out.println(insertedItem);
				
				preState.setInt(1, ordID);
				preState.setInt(2, itemID);
				preState.setFloat(3, insertedItem.getPrice());
				preState.setString(4, insertedItem.getCategory());
				preState.setString(5, insertedItem.getProduct());
				preState.executeUpdate();
								
				String query3 = "SELECT * FROM pos;";
				preState = conn.prepareStatement(query3);
				ResultSet ordered = preState.executeQuery();
				//System.out.println(ordered);
				
				while (ordered.next()) {
					
					Items newItem = convertResultsItem(ordered);
					
					orderBasket.add(newItem);
				}
				
			//} 
			
			return orderBasket;	
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Items convertResultsItem(ResultSet result) {
		
		try {
			//result.next();
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
	
	public Orders convertResultsOrd(ResultSet result) {
		
		try {
			int order_id = result.getInt("order_id");
			int fk_cust_id = result.getInt("fk_cust_id");
			float total = result.getFloat("total");
			Date dated = result.getDate("dated");
			Time timed = result.getTime("timed");
			
			return new Orders(order_id, fk_cust_id, total, dated, timed);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
}
