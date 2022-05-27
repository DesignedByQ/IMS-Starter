package com.qa.ims.finalPrj.businesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.qa.ims.finalPrj.domain.PosItem;
import com.qa.ims.finalPrj.domain.Itm;
import com.qa.ims.finalPrj.domain.Ord;
import com.qa.ims.finalPrj.utils.DBC;

public class OrdShop {
	
	DBC manager = new DBC();

	Connection conn = manager.connect();

	PreparedStatement preState;
	
	CstShop convert = new CstShop();
	ItmShop convert1 = new ItmShop();
	
	public boolean addOrd() {
		
		try {
			
			//get the latest cust added and retrieve their id
			String query = "SELECT * FROM customers ORDER BY cust_id DESC LIMIT 1;"; 
			preState = conn.prepareStatement(query);
			
			ResultSet result = preState.executeQuery();
			
			result.next();
			int custID = convert.convertResultsCust(result).getCust_id();
			
			
			String query1 = "INSERT INTO orders (total, cust_id) VALUES (?,?);";
			preState = conn.prepareStatement(query1);

			preState.setFloat(1, 0);
			preState.setInt(2, custID);
			
			preState.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean deleteOrdById(int id) {
		try {
			String query = "DELETE FROM orders WHERE ord_id = ?";
			preState = conn.prepareStatement(query);

			preState.setInt(1, id); // setting the value of ? to our id
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Ord> getAllOrd() {

		// Empty arrayList to be populated with ord
		ArrayList<Ord> ordList = new ArrayList<Ord>();

		try {
			String query = "SELECT * FROM orders";
			preState = conn.prepareStatement(query);
			ResultSet result = preState.executeQuery();

			while (result.next()) {
				
				Ord newOrd = convertResultsOrd(result);
				
				ordList.add(newOrd);
			}
			return ordList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addItemToOrd(Itm itm) {
		
		try {	
			//get the latest ord added and retrieve its id
			String query = "SELECT * FROM orders ORDER BY ord_id DESC LIMIT 1;";
			preState = conn.prepareStatement(query);
			
			ResultSet result = preState.executeQuery();
			
			result.next();
			int ordID = convertResultsOrd(result).getOrd_id();
			
			String prodName = itm.getProduct();
			
			String query1 = "SELECT * FROM items WHERE product = ?";
			preState = conn.prepareStatement(query1);
			preState.setString(1, prodName);
			
			ResultSet result1 = preState.executeQuery();
			
			result1.next();
			Itm selectedItem = convert1.convertResultsItem(result1);
			
			String query2 = "INSERT INTO pos (ord_id, price, product) VALUES (?,?,?);";
			preState = conn.prepareStatement(query2);
			preState.setInt(1, ordID);
			preState.setFloat(2, selectedItem.getPrice());
			preState.setString(3, selectedItem.getProduct());
			
			preState.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean deleteItemInOrd(int id) {
		try {
			String query = "DELETE FROM pos WHERE pos_id = ?";
			preState = conn.prepareStatement(query);

			preState.setInt(1, id); // setting the value of ? to our id
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
	public ArrayList<PosItem> purchaseItems() {
		
		//select all items in pos!
		//put them in a arraylist!
		//calc the cost!
		//syso the cost!
		//update the order total!
		//trauncate the pos
		
		ArrayList<PosItem> basket = new ArrayList<PosItem>();
		
		try {
			String query = "SELECT * FROM pos";
			preState = conn.prepareStatement(query);
			ResultSet result = preState.executeQuery();

			while (result.next()) {
				
				PosItem purchased = convertResultsPosItem(result);
				
				basket.add(purchased);
			}
			
			float total = 0;
			
			for (int i = 0; i < basket.size(); i++) {
				//System.out.println(basket.get(i).getCost()); 
				total += basket.get(i).getPrice();
			}
			
			System.out.println("The cost of your total order is £" + total);
			
			for (int i = 0; i < basket.size(); i++) {
				System.out.println(basket.get(i));
			}
			
			//get the latest ord added and retrieve its id
			String query1 = "SELECT * FROM orders ORDER BY ord_id DESC LIMIT 1;";
			preState = conn.prepareStatement(query1);
			
			ResultSet result2 = preState.executeQuery();
			
			result2.next();
			int ordID = convertResultsOrd(result2).getOrd_id();
			
			//update the total cost in the order based on the items selected
			String query2 = "UPDATE orders SET total = ? WHERE ord_id = ?;";
			preState = conn.prepareStatement(query2);
			preState.setFloat(1, total);
			preState.setInt(2, ordID);
			
			preState.executeUpdate();
			
			//clear all the pos basket for the next order
			String query3 = "TRUNCATE TABLE pos;"; 
			preState = conn.prepareStatement(query3);
			preState.executeUpdate();
			System.out.println("Purchase complete!");
			
			return basket;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public PosItem convertResultsPosItem(ResultSet result) {
		
		try {
			int pos_id = result.getInt("pos_id");
			int ord_id = result.getInt("ord_id");
			float price = result.getFloat("price");
			String product = result.getString("product");
						
			return new PosItem(pos_id, ord_id, price, product);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public Ord convertResultsOrd(ResultSet result) {
		
		try {
			int ord_id = result.getInt("ord_id");
			float total = result.getFloat("total");
			int cust_id = result.getInt("cust_id");
						
			return new Ord(ord_id, total, cust_id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
}
