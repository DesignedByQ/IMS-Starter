package com.qa.ims.persistence.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.Test;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.project2.Customers;
import com.qa.ims.project2.Items;
import com.qa.ims.project2.Store;
import com.qa.ims.utils.DBUtils;

public class CustomerTest {
	
	CustomerDAO shop = new CustomerDAO();
	
	DBUtils db = new DBUtils();
	Connection conn = db.getConnection(); 
	
	//Test customers
	Customer cust1 = new Customer("barack", "obama");
	Customer cust1ID = new Customer(1, "barack", "obama");
	Customer cust2 = new Customer("alicia", "keys");
	Customer cust2ID = new Customer(2, "alicia", "keys");
		
	@BeforeEach
	public void setup() {
		
		try {
			
			String query1 = "TRUNCATE table customers;";
			
			String query2 = "INSERT INTO customers(first_name, surname) VALUES('barack', 'obama');";
			PreparedStatement preStmt1 = conn.prepareStatement(query1);
			PreparedStatement preStmt2 = conn.prepareStatement(query2);
			
			preStmt1.executeUpdate();
			preStmt2.executeUpdate();
			
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		itemList.clear();
//		itemList.add(item1ID);
//				
//		custList.clear();
//		custList.add(cust1ID);
			
	}		

//	@Test
//	public void testEquals() {
//		EqualsVerifier.simple().forClass(Customer.class).verify(); 
//	}
	
	@Test
	public void createCustTest() {
		Customer result;
		
		result = shop.create(cust2);
		
		Assertions.assertEquals(cust2ID, result);
				
	}
	
}
