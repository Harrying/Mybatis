package com.briup.bean;

import java.util.Date;

public class Student {
	private Integer studId; 
	private String name; 
	private String email; 
	private Date dob;
	
	//�Զ������  typeHandler��������ת��
	private PhoneNumber phone;
	//һ��һ��ϵ����
	private Address address;
	
	public Student() {}
	public Student(Integer studId, String name, String email, Date dob, PhoneNumber phone, Address address) {
		super();
		this.studId = studId;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phone = phone;
		this.address = address;
	}
	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
		this.studId = studId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public PhoneNumber getPhone() {
		return phone;
	}
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phone=" + phone
				+ ", address=" + address + "]";
	}
}
