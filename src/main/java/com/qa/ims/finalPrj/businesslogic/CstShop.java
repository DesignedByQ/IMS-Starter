package com.qa.ims.finalPrj.businesslogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.qa.ims.finalPrj.domain.Cst;
import com.qa.ims.finalPrj.utils.DBC;





public class CstShop {
	
	DBC manager = new DBC();

	Connection conn = manager.connect();

	PreparedStatement preState;
	
	public boolean addCst(Cst cst) {
		try {
			String query = "INSERT INTO customers (first_name, last_name) VALUES (?,?);";
			preState = conn.prepareStatement(query);

			preState.setString(1, cst.getFirst_name());
			preState.setString(2, cst.getLast_name());
			
			preState.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	public boolean updateCstById(int id, Cst cst) {
		try {
			String query = "UPDATE customers SET first_name = ?, last_name = ? WHERE cust_id = ?";
			preState = conn.prepareStatement(query);
			preState.setString(1, cst.getFirst_name());
			preState.setString(2, cst.getLast_name());
			preState.setInt(3, id); 
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace(); 
			return false;
		}

	}
	
	public ArrayList<Cst> getAllCst() {

		// Empty arrayList to be populated with cst
		ArrayList<Cst> custList = new ArrayList<Cst>();

		try {
			String query = "SELECT * FROM customers";
			preState = conn.prepareStatement(query);
			ResultSet result = preState.executeQuery();

			while (result.next()) {
				
				Cst newCust = convertResultsCust(result);
				
				custList.add(newCust);
			}
			return custList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteCstById(int id) {
		try {
			String query = "DELETE FROM customers WHERE cust_id = ?";
			preState = conn.prepareStatement(query);

			preState.setInt(1, id); // setting the value of ? to our id
			preState.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
	
	
	public Cst convertResultsCust(ResultSet result) {
		
		try {
			int cust_id = result.getInt("cust_id");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			
			return new Cst(cust_id, first_name, last_name);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	
}
