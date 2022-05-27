package com.qa.ims.finalPrj;

public class PosItem {
	
	private int pos_id;
	private int ord_id;
	private float price;
	private String product;
	
	public PosItem(int ord_id, float price, String product) {
		super();
		this.ord_id = ord_id;
		this.price = price;
		this.product = product;
	}

	public PosItem(int pos_id, int ord_id, float price, String product) {
		super();
		this.pos_id = pos_id;
		this.ord_id = ord_id;
		this.price = price;
		this.product = product;
	}

	public int getPos_id() {
		return pos_id;
	}

	public void setPos_id(int pos_id) {
		this.pos_id = pos_id;
	}

	public int getOrd_id() {
		return ord_id;
	}

	public void setOrd_id(int ord_id) {
		this.ord_id = ord_id;
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
		return "PosItem [pos_id=" + pos_id + ", ord_id=" + ord_id + ", price=" + price + ", product=" + product + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ord_id;
		result = prime * result + pos_id;
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
		PosItem other = (PosItem) obj;
		if (ord_id != other.ord_id)
			return false;
		if (pos_id != other.pos_id)
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
