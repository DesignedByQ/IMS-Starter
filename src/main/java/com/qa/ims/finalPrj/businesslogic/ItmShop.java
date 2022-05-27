package com.qa.ims.finalPrj.businesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.qa.ims.finalPrj.domain.Itm;
import com.qa.ims.finalPrj.utils.DBC;

public class ItmShop {

	DBC manager = new DBC();

	Connection conn = manager.connect();

	PreparedStatement preState;
	 
	public boolean addItm(Itm itm) {
		try {
			String query = "INSERT INTO items (price, product) VALUES (?,?);";
			preState = conn.prepareStatement(query);

			preState.setFloat(1, itm.getPrice());
			preState.setString(2, itm.getProduct());
			
			preState.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean updateItmById(int id, Itm itm) {
		try {
			String query = "UPDATE items SET price = ?, product = ? WHERE item_id = ?";
			preState = conn.prepareStatement(query);
			preState.setFloat(1, itm.getPrice());
			preState.setString(2, itm.getProduct());
			preState.setInt(3, id);
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace(); 
			return false;
		}

	}
	
	public ArrayList<Itm> getAllItm() {

		// Empty arrayList to be populated with itm
		ArrayList<Itm> itemList = new ArrayList<Itm>();

		try {
			String query = "SELECT * FROM items";
			preState = conn.prepareStatement(query);
			ResultSet result = preState.executeQuery();

			while (result.next()) {
				
				Itm newItem = convertResultsItem(result);
				
				itemList.add(newItem);
			}
			return itemList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteItmById(int id) {
		try {
			String query = "DELETE FROM items WHERE item_id = ?";
			preState = conn.prepareStatement(query);

			preState.setInt(1, id); // setting the value of ? to our id
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Itm convertResultsItem(ResultSet result) {
		
		try {
			int item_id = result.getInt("item_id");
			float price = result.getFloat("price");
			String product = result.getString("product");
			
			return new Itm(item_id, price, product);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
