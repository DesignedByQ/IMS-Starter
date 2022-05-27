package com.qa.ims.project2;

public class Customers {
	
	private int cust_id;
	private String forename;
	private String surname;
	private String email;
	private String phone;
	
	public Customers(String forename, String surname, String email, String phone) {
		super();
		this.forename = forename;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}

	public Customers(int cust_id, String forename, String surname, String email, String phone) {
		super();
		this.cust_id = cust_id;
		this.forename = forename;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setLastname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customers [cust_id=" + cust_id + ", forename=" + forename + ", surname=" + surname + ", email="
				+ email + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cust_id;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((forename == null) ? 0 : forename.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Customers other = (Customers) obj;
		if (cust_id != other.cust_id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (forename == null) {
			if (other.forename != null)
				return false;
		} else if (!forename.equals(other.forename))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

}
