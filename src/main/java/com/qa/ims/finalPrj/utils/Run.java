package com.qa.ims.finalPrj.utils;

import com.qa.ims.finalPrj.businesslogic.CstShop;
import com.qa.ims.finalPrj.businesslogic.ItmShop;
import com.qa.ims.finalPrj.businesslogic.OrdShop;
import com.qa.ims.finalPrj.controllers.CstCont;
import com.qa.ims.finalPrj.controllers.ItmCont;
import com.qa.ims.finalPrj.controllers.OrdCont;
import com.qa.ims.finalPrj.domain.Cst;
import com.qa.ims.finalPrj.domain.Itm;

public class Run {
	
	public static void main(String[] args) {
		
		DBC db = new DBC();
		
		db.connect();
		
		//Controller objects
		CstShop customers = new CstShop();
		CstCont controller = new CstCont(customers);
		ItmShop items = new ItmShop();
		ItmCont controller1 = new ItmCont(items);
		OrdShop orders = new OrdShop();
		OrdCont controller2 = new OrdCont(orders);
		
		//Shop objects
		CstShop store = new CstShop(); 
		ItmShop store1 = new ItmShop(); 
		OrdShop store2 = new OrdShop(); 
		
		//sample customers
		Cst cust1 = new Cst("octopus", "charcoal");
		Cst cust2 = new Cst("bob", "charlie");
		Cst cust3 = new Cst("joe", "martinez"); 
		
		//sample items
		Itm hat = new Itm(20.00f, "hat");
		Itm shoes = new Itm(50.50f, "shoes");
		Itm phone = new Itm(240.99f, "phone");
		
		/* Main runner methods to create, update delete and view all customers */
		
		//System.out.println(controller.addCustController(cust1));
				
		//System.out.println(controller.updateByIdController(1, cust2));
		
		//System.out.println(controller.getAllCustController());
		
		//System.out.println(controller.deleteCustByIdController(2));
		
		/* Main runner methods to create, update delete and view all items */
		
		//System.out.println(controller1.addItemController(shoes));
				
		//System.out.println(controller1.updateItemByIdController(1, hat));
		
		//System.out.println(controller1.getAllItemController());
		
		//System.out.println(controller1.deleteItemByIdController(3));
		
		/* Main runner methods to create, delete and view all orders also to add, delete and calculate cost for all items */
		
		//System.out.println(controller2.addOrdController());
		
		//System.out.println(controller2.deleteOrderByIdController(2));
		
		//System.out.println(controller2.getAllOrdController());
		
		//System.out.println(controller2.addItemToOrdController(hat));
		
		//System.out.println(controller2.deleteItemByIdController(3));
		
		//controller2.purchaseItemsController(); 
	}
	
	
}
