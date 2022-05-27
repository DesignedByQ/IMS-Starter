package com.qa.ims.finalPrj;

public class Run {
	
	public static void main(String[] args) {
		
		DBC db = new DBC();
		
		db.connect();
		
		CstShop store = new CstShop(); 
		ItmShop store1 = new ItmShop(); 
		OrdShop store2 = new OrdShop(); 
		
		//customers
		Cst cust1 = new Cst("octopus", "charcoal");
		Cst cust2 = new Cst("bob", "charlie");
		Cst cust3 = new Cst("joe", "martinez");
		
		//items
		Itm hat = new Itm(20.00f, "hat");
		Itm shoes = new Itm(50.50f, "shoes");
		Itm phone = new Itm(240.99f, "phone");
		
		//System.out.println(store.addCst(cust1));
		//System.out.println(store.addCst(cust2));
		
		//System.out.println(store.updateCstById(2, cust3));
		
		//System.out.println(store.getAllCst());
		
		//System.out.println(store.deleteCstById(3));
		
		//System.out.println(store1.addItm(shoes));
		//System.out.println(store1.addItm(phone));
		
		//System.out.println(store1.updateItmById(2, item3));
		
		//System.out.println(store1.getAllItm());
		
		//System.out.println(store1.deleteItmById(2));
		
		//System.out.println(store2.addOrd());
		
		//System.out.println(store2.deleteOrdById(1));
		
		//System.out.println(store2.getAllOrd());
		
		//System.out.println(store2.addItemToOrd(shoes));
		
		//System.out.println(store2.deleteItemInOrd(1));
		
		//store2.purchaseItems();
	}
	
	
}
