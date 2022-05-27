package com.qa.ims.finalPrj.controllers;

import java.util.ArrayList;

import com.qa.ims.finalPrj.domain.Itm;
import com.qa.ims.finalPrj.businesslogic.ItmShop;

public class ItmCont {
	
	private ItmShop staff;

	public ItmCont(ItmShop staff) {
		super();
		this.staff = staff;
	}
	
	public boolean addItemController(Itm itm) {
		boolean addedItm = staff.addItm(itm);
		System.out.println(itm.getProduct() + " has been added");
		return addedItm;
	} 
	
	public boolean updateItemByIdController(int id, Itm itm) {
		System.out.println(itm.getProduct() + " has replaced the old item");
		boolean updatedItm = staff.updateItmById(id, itm);
		return updatedItm;
	}
	
	public ArrayList<Itm> getAllItemController(){
		ArrayList<Itm> item = staff.getAllItm();
		return item;
	} 
	
	public boolean deleteItemByIdController(int id) {
		boolean deletedCust = staff.deleteItmById(id);
		System.out.println("Item with id " + id + " has been deleted");
		return deletedCust;
	}
	

}
