package com.qa.ims.project2;

public class Items {
	
	private int item_id;
	private float price;
	private String category;
	private String product;
	
	public Items(float price, String category, String product) {
		super();
		this.price = price;
		this.category = category;
		this.product = product;
	}

	public Items(int item_id, float price, String category, String product) {
		super();
		this.item_id = item_id;
		this.price = price;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Items [item_id=" + item_id + ", price=" + price + ", category=" + category + ", product=" + product
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
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
		Items other = (Items) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
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
