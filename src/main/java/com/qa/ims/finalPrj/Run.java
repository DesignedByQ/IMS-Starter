package com.qa.ims.finalPrj;

public class Run {
	
	public static void main(String[] args) {
		
		DBC db = new DBC();
		
		db.connect();
		
		CstShop store = new CstShop(); 
		ItmShop store1 = new ItmShop(); 
		
		//customers
		Cst cust1 = new Cst("octopus", "charcoal");
		Cst cust2 = new Cst("bob", "charlie");
		Cst cust3 = new Cst("joe", "martinez");
		
		//items
		Itm item1 = new Itm(20.00f, "hat");
		Itm item2 = new Itm(50.50f, "shoes");
		Itm item3 = new Itm(240.99f, "phone");
		
		//System.out.println(store.addCst(cust1));
		//System.out.println(store.addCst(cust2));
		
		//System.out.println(store.updateCstById(2, cust3));
		
		//System.out.println(store.getAllCst());
		
		//System.out.println(store.deleteCstById(3));
		
		//System.out.println(store1.addItm(item1));
		//System.out.println(store1.addItm(item2));
		
		//System.out.println(store1.updateItmById(2, item3));
		
		//System.out.println(store1.getAllItm());
		
		//System.out.println(store1.deleteItmById(2));
	}
	
	
}
