package com.qa.ims.project;

public class Orders {
	
	private int order_id;
	private int customer_id;
	private int items_qty;
	private float total;
	private int date;
	private int time;
	
	public Orders(int customer_id, int items_qty, float total, int date, int time) {
		super();
		this.customer_id = customer_id;
		this.items_qty = items_qty;
		this.total = total;
		this.date = date;
		this.time = time;
	}

	public Orders(int order_id, int customer_id, int items_qty, float total, int date, int time) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.items_qty = items_qty;
		this.total = total;
		this.date = date;
		this.time = time;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getItems_qty() {
		return items_qty;
	}

	public void setItems_qty(int items_qty) {
		this.items_qty = items_qty;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", customer_id=" + customer_id + ", items_qty=" + items_qty + ", total="
				+ total + ", date=" + date + ", time=" + time + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customer_id;
		result = prime * result + date;
		result = prime * result + items_qty;
		result = prime * result + order_id;
		result = prime * result + time;
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
		if (customer_id != other.customer_id)
			return false;
		if (date != other.date)
			return false;
		if (items_qty != other.items_qty)
			return false;
		if (order_id != other.order_id)
			return false;
		if (time != other.time)
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
			return false;
		return true;
	}	

}
