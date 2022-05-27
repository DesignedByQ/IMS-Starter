package com.qa.ims.project;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class StoreTest {
	
	Store shop = new Store();
	
	DBconfig db = new DBconfig();
	Connection conn = db.connectDB(); 
	 
	//Test fish
	Items item1 = new Items(200.00f, "handheld", "psp", false, 10);
	Fish fish1ID = new Fish(1, "eel", "brown", 20, 13.55f);
	Fish fish2 = new Fish("catfish", "black", 13, 2.15f);
	Fish fish2ID = new Fish(2, "catfish", "black", 13, 2.15f);
	
	

}
