package com.nj.admin.xml;

public class Address {

	private int id;
	private String add;
	private String zipcode;

	public Address(int id, String add, String zipcode) {
		this.id = id;
		this.add = add;
		this.zipcode = zipcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}