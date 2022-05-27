package com.qa.ims.finalPrj.domain;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;



public class Ord {
	
	private int ord_id;
	private float total;
	private int cust_id;
	
	public Ord(float total, int cust_id) {
		super();
		this.total = total;
		this.cust_id = cust_id;
	}

	public Ord(int ord_id, float total, int cust_id) {
		super();
		this.ord_id = ord_id;
		this.total = total;
		this.cust_id = cust_id;
	}
 
	public int getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	@Override
	public String toString() {
		return "Ord [ord_id=" + ord_id + ", total=" + total + ", cust_id=" + cust_id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cust_id;
		result = prime * result + ord_id;
		result = prime * result + Float.floatToIntBits(total);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ord other = (Ord) obj;
		if (cust_id != other.cust_id)
			return false;
		if (ord_id != other.ord_id)
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		return true;
	}	

}
