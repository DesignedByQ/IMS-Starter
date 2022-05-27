package com.qa.ims.finalPrj;

import java.util.ArrayList;



public class CstCont {
	
	private CstShop staff;

	public CstCont(CstShop staff) {
		super();
		this.staff = staff;
	}
	
	public boolean addCustController(Cst cst) {
		boolean addedCst = staff.addCst(cst);
		System.out.println(cst.getFirst_name() + " " + cst.getLast_name() + " has been added");
		return addedCst;
	}
	
	public boolean updateCustByIdController(int id, Cst cst) {
		System.out.println(cst.getFirst_name() + " " + cst.getLast_name() + " has replaced the old customer");
		boolean updatedCst = staff.updateCstById(id, cst);
		//System.out.println(cst.getFirst_name() + " " + cst.getLast_name());
		return updatedCst;
	}
	
	public ArrayList<Cst> getAllCustController(){
		ArrayList<Cst> cust = staff.getAllCst();
		return cust;
	} 
	
	public boolean deleteCustByIdController(int id) {
		boolean deletedCust = staff.deleteCstById(id);
		System.out.println("Cust with id " + id + " has been deleted");
		return deletedCust;
	}
	

}
