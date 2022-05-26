package com.qa.ims.project2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.qa.ims.project2.Customers;
import com.qa.ims.project2.DBconfig;
import com.qa.ims.project2.Items;
import com.qa.ims.project2.Store;


public class StoreTest {
	
	Store shop = new Store();
	
	DBconfig db = new DBconfig();
	Connection conn = db.connectDB(); 
	 
	//Test items
	Items item1 = new Items(200.00f, "handheld", "psp");
	Items item1ID = new Items(1, 200.00f, "handheld", "psp");
	Items item2 = new Items(15.50f, "DVD", "aladdin");
	Items item2ID = new Items(2, 15.50f, "DVD", "aladdin");
	Items item3 = new Items(99.00f, "consoles", "playstation3");
	Items item3ID = new Items(3, 99.00f, "consoles", "playstation3");
	//Items xboxID = new Items(1, 399.00f, "consoles", "360");
	
	//Test customers
	Customers cust1 = new Customers("barack", "obama", "white.house@yahoo.com", "01565424358");
	Customers cust1ID = new Customers(1, "barack", "obama", "white.house@yahoo.com", "01565424358");
	Customers cust2 = new Customers("alicia", "keys", "a.keys@gmail.com", "07551660011");
	Customers cust2ID = new Customers(2, "alicia", "keys", "a.keys@gmail.com", "07551660011");
	
	public ArrayList<Items> itemList = new ArrayList<>();
	public ArrayList<Customers> custList = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		
		try {
			String query1 = "SET FOREIGN_KEY_CHECKS = 0;";
			String query2 = "TRUNCATE table items;";
			String query3 =	"SET FOREIGN_KEY_CHECKS = 1;";
			String query4 = "INSERT INTO items(price, category, product) VALUES(200.00, 'handheld', 'psp');";
			PreparedStatement preStmt1 = conn.prepareStatement(query1);
			PreparedStatement preStmt2 = conn.prepareStatement(query2);
			PreparedStatement preStmt3 = conn.prepareStatement(query3);
			PreparedStatement preStmt4 = conn.prepareStatement(query4);
			preStmt1.executeUpdate();
			preStmt2.executeUpdate();
			preStmt3.executeUpdate();
			preStmt4.executeUpdate();
			
			String query5 = "SET FOREIGN_KEY_CHECKS = 0;";
			String query6 = "TRUNCATE table customers;";
			String query7 =	"SET FOREIGN_KEY_CHECKS = 1;";
			String query8 = "INSERT INTO customers(forename, surname, email, phone) VALUES('barack', 'obama', 'white.house@yahoo.com', '01565424358');";
			PreparedStatement preStmt5 = conn.prepareStatement(query5);
			PreparedStatement preStmt6 = conn.prepareStatement(query6);
			PreparedStatement preStmt7 = conn.prepareStatement(query7);
			PreparedStatement preStmt8 = conn.prepareStatement(query8);
			preStmt5.executeUpdate();
			preStmt6.executeUpdate();
			preStmt7.executeUpdate();
			preStmt8.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		itemList.clear();
		itemList.add(item1ID);
				
		custList.clear();
		custList.add(cust1ID);
		
	}
	
	@Test	
	public void addItemTest() {
		
		boolean result;
		
		result = shop.addItem(item2);
		
		//Assertions.assertSame(bird2ID, result);
		//Assertions.assertEquals(fish2ID, result);
		Assertions.assertTrue(result);
		
	}
	
	@Test
	public void viewAllItemsTest() {
		
		ArrayList<Items> result;
		
		result = shop.viewAllItems();
		
		System.out.println(result);
		
		Assertions.assertEquals(itemList, result);
	}
	
	@Test	
	public void updateItemTest() {
				
		boolean result;
		
		result = shop.updateItem(item3, 1);
		
		Assertions.assertTrue(result); 
		    
	}
	
	@Test	
	public void deleteItemTest() {
				
		boolean result;
		
		result = shop.deleteItemById(1);
		
		Assertions.assertTrue(result); 
		    
	}
	
	@Test	
	public void addCustTest() {
		
		boolean result;
		
		result = shop.addCust(cust2);
		
		//Assertions.assertSame(bird2ID, result);
		//Assertions.assertEquals(fish2ID, result);
		Assertions.assertTrue(result);
		
	}
	
	@Test
	public void viewAllCustTest() {
		
		ArrayList<Customers> result;
		
		result = shop.viewAllCust();
		
		System.out.println(result);
		
		Assertions.assertEquals(custList, result);
	}
	
	@Test	
	public void updateCustTest() {
				
		boolean result;
		
		result = shop.updateCust(cust2, 1);
		
		Assertions.assertTrue(result); 
		    
	}
	
	@Test	
	public void deleteCustTest() {
				
		boolean result;
		
		result = shop.deleteCustById(1);
		
		Assertions.assertTrue(result); 
		    
	}

}