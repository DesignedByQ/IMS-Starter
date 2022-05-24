package com.qa.ims.project;

public class Items {
	
	private int id;
	private float price;
	private String category;
	private String type;
	private boolean adultRes;
	private int stock;
	
	public Items(float price, String category, String type, boolean adultRes, int stock) {
		super();
		this.price = price;
		this.category = category;
		this.type = type;
		this.adultRes = adultRes;
		this.stock = stock;
	}

	public Items(int id, float price, String category, String type, boolean adultRes, int stock) {
		super();
		this.id = id;
		this.price = price;
		this.category = category;
		this.type = type;
		this.adultRes = adultRes;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAdultRes() {
		return adultRes;
	}

	public void setAdultRes(boolean adultRes) {
		this.adultRes = adultRes;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", price=" + price + ", category=" + category + ", type=" + type + ", adultRes="
				+ adultRes + ", stock=" + stock + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adultRes ? 1231 : 1237);
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + stock;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Items other = (Items) obj;
		if (adultRes != other.adultRes)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (stock != other.stock)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
	
	
	
}
