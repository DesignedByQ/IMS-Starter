package com.qa.ims.project;

import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) {
		
		//DB connection
		DBconfig configuration = new DBconfig();
		
		configuration.connectDB();
		
		//System items
		Items starwars = new Items(40.00f, "consoles", "video games", true, 10);
		Items fifa22 = new Items(40.00f, "consoles", "video games", true, 10);
		
		//Business logic
		Store staff = new Store();
		
		System.out.println(staff.addItem(starwars));
	}

}
