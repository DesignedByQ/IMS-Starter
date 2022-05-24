package com.qa.ims.project;

import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) {
		
		//DB Connection
		DBconfig configuration = new DBconfig();
		
		configuration.connectDB();
		
		//System items
		Items starwars = new Items(40.00f, "video games", "star wars", true, 10);
		Items fifa22 = new Items(45.00f, "video games", "fifa 22", false, 10);
		Items ps5 = new Items(499.00f, "consoles", "playstation 5", false, 10);
		
		//System customers
		Customers cust1 = new Customers("nelson", "mandela", "n.mandela@hotmail.com", "07765424358");
		Customers cust2 = new Customers("beyonce", "knowles", "destiny.c@gmail.com", "07547223011");
		Customers cust3 = new Customers("jackie", "brown", "pam.g@outlook.co.uk", "07545831564");
		
		//Business Logic
		Store staff = new Store();
		
		//System.out.println(staff.addItem(fifa22));
		
		//System.out.println(staff.viewAllItems());
		
		//System.out.println(staff.updateItem(ps5, 3));
		
		//System.out.println(staff.deleteItemById(2));
				
		//System.out.println(staff.addCust(cust2));
		
		//System.out.println(staff.viewAllCustomers());
		
		//System.out.println(staff.updateCustomer(cust3, 1));
		
		//System.out.println(staff.deleteCustomerById(2));
		
		
	}

}
