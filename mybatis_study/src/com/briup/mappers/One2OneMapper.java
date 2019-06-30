package com.briup.mappers;

import java.util.List;

import com.briup.bean.Address;
import com.briup.bean.Student;

/*
 * 一对一 映射接口
 */
public interface One2OneMapper {
	//根据地址编号  获取地址对象
	public abstract Address findAddressById(int id);
	
	//获取所有地址对象
	public abstract List<Address> findAllAddresses();
	
	//获取一个学生对象【包含地址信息】
	public abstract Student findStudentById(int id);

	//查询得多所有学生对象【包含地址】
	public abstract List<Student> findAllStudents();
	
	//嵌套结果查询 获取 学生对象
	public abstract Student findStudentByIdWithoutAddress(int id);
	
	//插入地址信息
	public abstract void insertAddress(Address addr);
	
	//插入学生信息
	public abstract void insertStudentWithAddress(Student stu);
}






