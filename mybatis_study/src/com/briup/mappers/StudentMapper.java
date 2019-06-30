package com.briup.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.briup.pojo.Student;

/*
 * 映射接口 包含具体的方法【sql语句 】
 */
public interface StudentMapper {
	
	//具体函数的返回值，由用户自己设置
	//如果函数的返回值 是List<类型>，则映射文件 sql语句中 resultType="类型";
	public List<Student> findAllStudents();
	
	//注意: 如果函数想返回一个 List集合，则resultType应该写list存放成员的类型
	//	List在mybatis十分特殊，不能resultType="list" ERROR
	//如果要返回多个对象resultType="map" ，自动放入List集合中
	public List<Map<String,Object>> findAllStudent_Map();
	
	public Student findStudentById(Integer id);
	
	//查询一个学生信息  映射到 map集合中
	public Map<String,Object> findStudentById_Map(Integer id);
	public List<Object> findStudentById_List(Integer id);
	
	//将student对象 添加到数据库表中
	public void insertStudent2(Student stu);
	
	public abstract void updateStudent(Student s);
	
	public abstract void deleteStudent(int id);
	
	//获取数据库中 学生个数
	public abstract int getStudentSize();
	
	public abstract String getNameById();
	
	public abstract List<String> getAllNames();
}







