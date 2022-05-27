package com.qa.ims.project2;

import java.util.Scanner;

import com.qa.ims.project.Customers;
import java.time.LocalDate;

public class Runner {
	
	public static void main(String[] args) {
		
		//DB Connection
		DBconfig configuration = new DBconfig();
		
		configuration.connectDB();
		
		//System items
		Items starwars = new Items(40.00f, "video games", "starwars");
		Items fifa22 = new Items(45.00f, "video games", "fifa22");
		Items ps5 = new Items(499.00f, "consoles", "playstation5");
		Items xbox = new Items(399.00f, "consoles", "360");
		Items nintendo = new Items(250.00f, "consoles", "wii");
		
		//System customers
		Customers cust1 = new Customers("nelson", "mandela", "n.mandela@hotmail.com", "07765424358");
		Customers cust2 = new Customers("beyonce", "knowles", "destiny.c@gmail.com", "07547223011");
		Customers cust3 = new Customers("jackie", "brown", "pam.g@outlook.co.uk", "07545831564");
		
		//System orders
		//Orders newOrd = new Orders();
		
		//Business Logic
		Store staff = new Store();
		
		
		
		//System.out.println(staff.addItem(ps5));
		
		//System.out.println(staff.viewAllItems());
		
		//System.out.println(staff.updateItem(starwars, 3));
		
		//System.out.println(staff.deleteItemById(8));
				
		//System.out.println(staff.addCust(cust2));
		
		//System.out.println(staff.viewAllCust());
		
		//System.out.println(staff.updateCust(cust3, 2));
		
		//System.out.println(staff.deleteCustById(2));
		
		//System.out.println(staff.createOrder());
		
		System.out.println(staff.addItemToOrder(1));
		
		
	}

}

