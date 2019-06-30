package com.briup.homework;

import java.util.Date;

import com.briup.pojo.PhoneNumber;

//Aliasע�⣬��<package>���ʹ�ã�������ı���
//@Alias("Tea")
public class Teacher {
	//Integer tid;
	int tid;
	String name;
	double salary;
	Date start_date;
	
	//�Զ������
	//��mybatis�ײ㣬���Զ�������  ��  ���ݿ�����ӳ�䣬����һ��Ҫ��֤ �����������Ͷ�Ӧ
	//	varchar2 -- String
	//	number   -- int double float short 
	//	date 	 -- java.sql.Date  java.*.Timestamp
	//	varchar2(30)  -- �Զ������Addr  error
	//		psҲû��setAddr����
	//	����ת����ʱ�򣬻��������
	private PhoneNumber addr;
	
	//
	public Teacher() {}
	
	public Teacher(int tid, String name, double salary, Date start_date) {
		super();
		this.tid = tid;
		this.name = name;
		this.salary = salary;
		this.start_date = start_date;
	}

	public Teacher(String name, double salary, Date date) {
		this(0,name,salary,date);
	}

	public Teacher(int tid, String name, double salary, Date start_date, PhoneNumber addr) {
		super();
		this.tid = tid;
		this.name = name;
		this.salary = salary;
		this.start_date = start_date;
		this.addr = addr;
	}

	public PhoneNumber getAddr() {
		System.out.println("getAddr()...");
		return addr;
	}

	public void setAddr(PhoneNumber addr) {
		System.out.println("set Addr...");
		this.addr = addr;
	}

	//mybatis�ײ���Զ�����getX������ȡ���������ֵ�����û���ṩget������mybaitsҲ���Դ���
	public int getTid() {
		//System.out.println("getTid()...");
		return tid;
	}

	public void setTid(int tid) {
		System.out.println("set tid...");
		this.tid = tid;
	}

	public String getName() {
		//System.out.println("getName()...");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", salary=" + salary + ", start_date=" + start_date + "]";
	}
}







