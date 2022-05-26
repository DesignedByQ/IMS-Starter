package com.qa.ims.project2;

import java.sql.Date;
import java.sql.Time;

public class Orders {
	
	private int order_id;
	private int fk_cust_id;
	private float total;
	private Date dated;
	private Time timed;
	
	public Orders(int fk_cust_id, float total, Date dated, Time timed) {
		super();
		this.fk_cust_id = fk_cust_id;
		this.total = total;
		this.dated = dated;
		this.timed = timed;
	}

	public Orders(int order_id, int fk_cust_id, float total, Date dated, Time timed) {
		super();
		this.order_id = order_id;
		this.fk_cust_id = fk_cust_id;
		this.total = total;
		this.dated = dated;
		this.timed = timed;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
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

	public Date getDated() {
		return dated;
	}

	public void setDated(Date dated) {
		this.dated = dated;
	}

	public Time getTimed() {
		return timed;
	}

	public void setTimed(Time timed) {
		this.timed = timed;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", fk_cust_id=" + fk_cust_id + ", total=" + total + ", dated=" + dated
				+ ", timed=" + timed + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dated == null) ? 0 : dated.hashCode());
		result = prime * result + fk_cust_id;
		result = prime * result + order_id;
		result = prime * result + ((timed == null) ? 0 : timed.hashCode());
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
		Orders other = (Orders) obj;
		if (dated == null) {
			if (other.dated != null)
				return false;
		} else if (!dated.equals(other.dated))
			return false;
		if (fk_cust_id != other.fk_cust_id)
			return false;
		if (order_id != other.order_id)
			return false;
		if (timed == null) {
			if (other.timed != null)
				return false;
		} else if (!timed.equals(other.timed))
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		return true;
	}

}
