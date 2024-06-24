package com.qa.ims.project;

import java.util.Scanner;

public class Runner {
	
	public static void main(String[] args) {
		DBconfig configuration = new DBconfig();
		
		
		configuration.connectDB();
	}

}
