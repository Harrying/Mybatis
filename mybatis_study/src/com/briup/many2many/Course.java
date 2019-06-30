package com.briup.many2many;

import java.util.List;

public class Course {
	private Integer id;
	private String courseCode; // 课程编号
	private String courseName;// 课程名称
	// 选课学生
	private List<Student> students;
	
	//mybatis底层 借助 无参构造器
	public Course() {}
	public Course(String courseCode, String courseName) {
		this.courseCode = courseCode;
		this.courseName = courseName;
	}
	public Course(Integer id, String courseCode, String courseName) {
		this.id = id;
		this.courseCode = courseCode;
		this.courseName = courseName;
	}
	public Course(Integer id, String courseCode, String courseName, List<Student> students) {
		this.id = id;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.students = students;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	//输出课程信息【不包括选课的学生】
	public void showCourseWithOutStudents() {
		System.out.println("Course基本信息: " + id + " " + courseCode + " " + courseName);
	}
	
	//输出课程信息【包括选课的学生】
	public void showCourseWithStudents() {
		System.out.println("Course所有信息: " + id + " " + courseCode + " " + courseName);
		for (Student s : students) {
			s.showStudentWithOutCourses();
		}
	}
	
}








