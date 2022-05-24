package com.qa.ims.project;

public class Items {
	
	private int item_id;
	private float price;
	private String category;
	private String type;
	private boolean adult_restricted;
	private int stock;
	
	public Items(float price, String category, String type, boolean adult_restricted, int stock) {
		super();
		this.price = price;
		this.category = category;
		this.type = type;
		this.adult_restricted = adult_restricted;
		this.stock = stock;
	}

	public Items(int item_id, float price, String category, String type, boolean adult_restricted, int stock) {
		super();
		this.item_id = item_id;
		this.price = price;
		this.category = category;
		this.type = type;
		this.adult_restricted = adult_restricted;
		this.stock = stock;
	}

	public int getItemId() {
		return item_id;
	}

	public void setItemId(int item_id) {
		this.item_id = item_id;
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
		return adult_restricted;
	}

	public void setAdultRes(boolean adult_restricted) {
		this.adult_restricted = adult_restricted;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Items [item_id=" + item_id + ", price=" + price + ", category=" + category + ", type=" + type + ", adult_restricted="
				+ adult_restricted + ", stock=" + stock + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adult_restricted ? 1231 : 1237);
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + item_id;
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
		if (adult_restricted != other.adult_restricted)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (item_id != other.item_id)
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
