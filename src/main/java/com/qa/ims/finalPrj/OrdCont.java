package com.qa.ims.finalPrj;

import java.util.ArrayList;

public class OrdCont {
	
	private OrdShop staff;

	public OrdCont(OrdShop staff) {
		super();
		this.staff = staff;
	}
	
	public boolean addOrdController() {
		boolean addedOrd = staff.addOrd();
		System.out.println("A new order has been created");
		return addedOrd;
	}
	
	public ArrayList<Ord> getAllOrdController(){
		ArrayList<Ord> order = staff.getAllOrd();
		return order;
	} 
	
	public boolean deleteOrderByIdController(int id) {
		boolean deletedOrder = staff.deleteOrdById(id);
		System.out.println("Order with id " + id + " has been deleted");
		return deletedOrder;
	}
	
	public boolean addItemToOrdController(Itm itm) {
		boolean addedItem = staff.addItemToOrd(itm);
		System.out.println("A new item has been added");
		return addedItem;
	}
	
	public boolean deleteItemByIdController(int id) {
		boolean deletedItem = staff.deleteItemInOrd(id);
		System.out.println("Item with id " + id + " has been deleted");
		return deletedItem;
	}
	
	public ArrayList<PosItem> purchaseItemsController(){
		ArrayList<PosItem> ordered = staff.purchaseItems();
		return ordered;
	} 
}
