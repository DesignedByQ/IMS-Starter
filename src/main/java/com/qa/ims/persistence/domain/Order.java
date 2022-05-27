package com.qa.ims.persistence.domain;

public class Order {
	
	private long ord_id;
	private int fk_cust_id;
	private float total;
	
	public Order(int fk_cust_id, float total) {
		super();
		this.fk_cust_id = fk_cust_id;
		this.total = total;
	}

	public Order(long ord_id, int fk_cust_id, float total) {
		super();
		this.ord_id = ord_id;
		this.fk_cust_id = fk_cust_id;
		this.total = total;
	}

	public long getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(long ord_id) {
		this.ord_id = ord_id;
	}

	public int getFk_cust_id() {
		return fk_cust_id;
	}

	public void setFk_cust_id(int fk_cust_id) {
		this.fk_cust_id = fk_cust_id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [ord_id=" + ord_id + ", fk_cust_id=" + fk_cust_id + ", total=" + total + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fk_cust_id;
		result = prime * result + (int) (ord_id ^ (ord_id >>> 32));
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
		Order other = (Order) obj;
		if (fk_cust_id != other.fk_cust_id)
			return false;
		if (ord_id != other.ord_id)
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		return true;
	}
	
}
