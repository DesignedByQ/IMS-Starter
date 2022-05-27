package com.qa.ims.finalPrj.domain;

public class Itm {
	
	private int item_id;
	private float price;
	private String product;
	
	public Itm(float price, String product) {
		super();
		this.price = price;
		this.product = product;
	}

	public Itm(int item_id, float price, String product) {
		super();
		this.item_id = item_id;
		this.price = price;
		this.product = product;
	}

	public int getItem_id() { 
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Itm [item_id=" + item_id + ", price=" + price + ", product=" + product + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + item_id;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		Itm other = (Itm) obj;
		if (item_id != other.item_id)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

}
