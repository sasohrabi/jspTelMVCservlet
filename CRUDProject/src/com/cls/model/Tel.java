package com.cls.model;

public class Tel {

	private int telId;
	private String firstName;
	private String lastName;
	private String address;
	private int num;
	
	public int getTelId() {
		return telId;
	}
	public void setTelId(int telId) {
		this.telId = telId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "tel [telId=" + telId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", address=" + address + ", num="
				+ num + "]";
	}
		
}
