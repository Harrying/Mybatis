package com.briup.bean;

public class Address {
	private Integer addrId;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(Integer addrId, String street, String city, String state, String zip, String country) {
		super();
		this.addrId = addrId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	public Integer getAddrId() {
		return addrId;
	}
	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [addrId=" + addrId + ", street=" + street + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", country=" + country + "]";
	}
}
