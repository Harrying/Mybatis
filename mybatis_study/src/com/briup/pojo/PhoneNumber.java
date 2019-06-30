package com.briup.pojo;

/*
 * 规定: 数据库表 'suzhou-gqj-5'
 * 		Addr addr1对象  --> 数据表 列
 */
public class PhoneNumber {
	private String city;
	private String street;
	private String id;
	
	public PhoneNumber() {}
	
	public PhoneNumber(String addr) {
		if(addr != null) {
			String[] arr = addr.split("-");
			city = arr[0];
			street = arr[1];
			id = arr[2];
		}
	}

	public PhoneNumber(String city, String street, String id) {
		this.city = city;
		this.street = street;
		this.id = id;
	}
	
	//以后用来将 addr对象 转换成 String字符串
	public String getAsString() {
		//this对象
		return city+"-"+street+"-"+id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PhoneNumber [city=" + city + ", street=" + street + ", id=" + id + "]";
	}
}
