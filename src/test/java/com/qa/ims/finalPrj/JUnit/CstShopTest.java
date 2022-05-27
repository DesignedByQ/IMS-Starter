package com.qa.ims.finalPrj.JUnit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.ims.finalPrj.Cst;
import com.qa.ims.finalPrj.CstShop;
import com.qa.ims.finalPrj.DBC;


public class CstShopTest {
	
	CstShop shop = new CstShop();
	
	DBC db = new DBC();
	Connection conn = db.connect(); 
	
	//test customers 
	Cst cust2 = new Cst("test first2", "test last2");
	Cst cust2ID = new Cst(2, "test first2", "test last2");
	Cst cust1 = new Cst("test first1", "test last1");
	Cst cust1ID = new Cst(1, "test first1", "test last1");
	 
	public ArrayList<Cst> custList = new ArrayList<>();
	
	@BeforeEach
	public void setup() {
		
		try {
			String query1 = "TRUNCATE TABLE customers;";
			String query2 = "INSERT INTO customers(first_name, last_name) VALUES('test first1', 'test last1');";
			PreparedStatement preStmt1 = conn.prepareStatement(query1);
			PreparedStatement preStmt2 = conn.prepareStatement(query2);
			preStmt1.executeUpdate();
			preStmt2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		custList.clear();
		custList.add(cust1ID);
		//birdList.add(bird2);
		
	}
	
	@Test	
	public void addCustTest() {
		
		boolean result;
		
		result = shop.addCst(cust1);
		
		Assertions.assertTrue(result);
		
	}
	
	@Test	
	public void updateCustTest() {
				
		boolean result;
		
		result = shop.updateCstById(1, cust1);
		
		Assertions.assertTrue(result); 
		    
	}
	
	@Test
	public void getAllCustTest() {
		
		ArrayList<Cst> result;
		
		result = shop.getAllCst();
		
		System.out.println(result);
		
		Assertions.assertEquals(custList, result);
	}
	
	@Test	
	public void deleteCustTest() {
				
		boolean result;
		
		int id = 1;
		
		result = shop.deleteCstById(id); 
		
		Assertions.assertTrue(result); 
		 
	}
	
}
