package com.qa.ims.finalPrj;

public class Run {
	
	public static void main(String[] args) {
		
		DBC db = new DBC();
		
		db.connect();
		
		Shop store = new Shop(); 
		
		//customers
		Cst cust1 = new Cst("octopus", "charcoal");
		Cst cust2 = new Cst("bob", "charlie");
		Cst cust3 = new Cst("joe", "martinez");
		
		//System.out.println(store.addCst(cust1));
		//System.out.println(store.addCst(cust2));
		
		//System.out.println(store.updateCstById(2, cust3));
		
		//System.out.println(store.getAllCst());
		
		//System.out.println(store.deleteCstById(3));
	}
	
	
}
