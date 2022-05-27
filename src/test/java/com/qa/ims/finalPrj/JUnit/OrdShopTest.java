package com.qa.ims.finalPrj.JUnit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.ims.finalPrj.utils.DBC;
import com.qa.ims.finalPrj.domain.Itm;
import com.qa.ims.finalPrj.domain.Ord;
import com.qa.ims.finalPrj.businesslogic.OrdShop;
import com.qa.ims.finalPrj.domain.PosItem;


public class OrdShopTest {
	
	OrdShop shop = new OrdShop();
	
	DBC db = new DBC();
	Connection conn = db.connect(); 
	
	//test orders 
	Ord order1 = new Ord(100.00f, 5);
	Ord order1ID = new Ord(1, 100.00f, 5);
	Ord order2 = new Ord(200.00f, 6);
	Ord order2ID = new Ord(2, 200.00f, 6);
	
	//test items
	Itm item1 = new Itm(999.99f, "test product1");
	Itm item1ID = new Itm(1, 999.99f, "test product1");
	Itm item2 = new Itm(999.99f, "test product2");
	Itm item2ID = new Itm(2, 999.99f, "test product2");
	
	//test pos items
	PosItem item3 = new PosItem(1, 999.99f, "test product1");
	PosItem item3ID = new PosItem(1, 1, 999.99f, "test product1");
	PosItem item4 = new PosItem(1, 999.99f, "test product2");
	PosItem item4ID = new PosItem(2, 1, 999.99f, "test product2");
	
	public ArrayList<Ord> orderList = new ArrayList<>();
	public ArrayList<PosItem> posList = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		
		try {
			String query1 = "TRUNCATE TABLE orders;";
			String query2 = "INSERT INTO orders(total, cust_id) VALUES(100.00, 5);";
			PreparedStatement preStmt1 = conn.prepareStatement(query1);
			PreparedStatement preStmt2 = conn.prepareStatement(query2);
			preStmt1.executeUpdate();
			preStmt2.executeUpdate();
			
			String query3 = "TRUNCATE TABLE pos;";
			String query4 = "INSERT INTO pos(ord_id, price, product) VALUES(1, 999.99, 'test product1');";
			PreparedStatement preStmt3 = conn.prepareStatement(query3);
			PreparedStatement preStmt4 = conn.prepareStatement(query4);
			preStmt3.executeUpdate();
			preStmt4.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		orderList.clear();
		orderList.add(order1ID);
		
		posList.clear();
		posList.add(item3ID);
		
	}
	
	@Test	
	public void addOrdTest() {
		
		boolean result;
		
		result = shop.addOrd();
		
		Assertions.assertTrue(result);
		
	}
	
	@Test
	public void getAllOrdTest() {
		
		ArrayList<Ord> result;
		
		result = shop.getAllOrd();
		
		System.out.println(result);
		
		Assertions.assertEquals(orderList, result);
	}
	
	@Test	
	public void deleteOrdTest() {
				
		boolean result;
		
		int id = 1;
		
		result = shop.deleteOrdById(id); 
		
		Assertions.assertTrue(result); 
		 
	}
	 
	@Test
	public void addItemToOrd() {
		
		boolean result;
		
		result = shop.addItemToOrd(item1);
		
		Assertions.assertTrue(result);
	}
	
	@Test
	public void deleteItemInOrd() {
		
		boolean result;
		
		result = shop.deleteItemInOrd(1);
		
		Assertions.assertTrue(result);
	}
	
	@Test
	public void purchaseItemsTest() {
		
		ArrayList<PosItem> result;
		
		result = shop.purchaseItems();
		
		System.out.println(result);
		
		Assertions.assertEquals(posList, result);
	}
}
