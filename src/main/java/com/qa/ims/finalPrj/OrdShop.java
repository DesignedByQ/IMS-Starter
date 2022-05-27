package com.qa.ims.finalPrj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.qa.aQAriamProjectNew.Fish;

public class OrdShop {
	
	DBC manager = new DBC();

	Connection conn = manager.connect();

	PreparedStatement preState;
	
	CstShop convert = new CstShop();
	
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
	
	public ArrayList<Itm> addItemToOrd(int id)
	
	
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
