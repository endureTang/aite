package com.nj.admin.xml;

import java.util.List;
 
public class Person {

	private int id;
	private int sex;
	private int age;
	private String name;
	private List<Address> addList;

	public Person(int id, int sex, int age, String name, List<Address> addList) {
		this.id = id;
		this.sex = sex;
		this.age = age;
		this.name = name;
		this.addList = addList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Address> getAddList() {
		return addList;
	}

	public void setAddList(List<Address> addList) {
		this.addList = addList;
	}

}