package com.qa.ims.finalPrj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ItmShopTest {
	
	ItmShop shop = new ItmShop();
	
	DBC db = new DBC();
	Connection conn = db.connect(); 
	
	//test items
	Itm item1 = new Itm(999.99f, "test product1");
	Itm item1ID = new Itm(1, 999.99f, "test product1");
	Itm item2 = new Itm(999.99f, "test product2");
	Itm item2ID = new Itm(2, 999.99f, "test product2");
	
	public ArrayList<Itm> itemList = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		 
		try {
			String query1 = "TRUNCATE TABLE items;";
			String query2 = "INSERT INTO items(price, product) VALUES(999.99, 'test product1');";
			PreparedStatement preStmt1 = conn.prepareStatement(query1);
			PreparedStatement preStmt2 = conn.prepareStatement(query2);
			preStmt1.executeUpdate();
			preStmt2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		itemList.clear();
		itemList.add(item1ID);
		//birdList.add(bird2);
		
	}
	
	@Test	
	public void addItemTest() {
		
		boolean result;
		
		result = shop.addItm(item1);
		
		Assertions.assertTrue(result);
		
	}
	
	@Test	
	public void updateItemTest() {
				
		boolean result;
		
		result = shop.updateItmById(1, item1);
		
		Assertions.assertTrue(result); 
		    
	}
	
	@Test
	public void getAllIItemTest() {
		
		ArrayList<Itm> result;
		
		result = shop.getAllItm();
		
		System.out.println(result);
		
		Assertions.assertEquals(itemList, result);
	}
	
	@Test	
	public void deleteItemTest() {
				
		boolean result;
		
		int id = 1;
		
		result = shop.deleteItmById(id); 
		
		Assertions.assertTrue(result); 
		 
	}
	
}

