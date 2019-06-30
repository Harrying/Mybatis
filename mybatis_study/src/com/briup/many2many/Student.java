package com.briup.many2many;

import java.util.List;

public class Student {
	private Integer id;
	private String name; // 姓名
	private String gender; // 性别
	private String major; // 专业
	private String grade; // 年级
	// 所选的课程
	private List<Course> courses;
	
	public Student() {}
	public Student(String name, String gender, String major, String grade) {
		this.name = name;
		this.gender = gender;
		this.major = major;
		this.grade = grade;
	}
	public Student(Integer id, String name, String gender, String major, String grade) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.major = major;
		this.grade = grade;
	}
	public Student(Integer id, String name, String gender, String major, String grade, List<Course> courses) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.major = major;
		this.grade = grade;
		this.courses = courses;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	//输出学生信息【包括所选课程】
	public void showStudentWithCourses() {
		System.out.println("Studen完整: " + id + " " + name + " " + gender + " " + major + " " + grade);
		for (Course c : courses) {
			c.showCourseWithOutStudents();
		}
	}
	
	//输出学生信息【不包括所选课程】
	public void showStudentWithOutCourses() {
		System.out.println("Studen基本: " + id + " " + name + " " + gender + " " + major + " " + grade);
	}
}
