package com.briup.many2many;

import java.util.List;

public class Student {
	private Integer id;
	private String name; // ����
	private String gender; // �Ա�
	private String major; // רҵ
	private String grade; // �꼶
	// ��ѡ�Ŀγ�
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
	
	//���ѧ����Ϣ��������ѡ�γ̡�
	public void showStudentWithCourses() {
		System.out.println("Studen����: " + id + " " + name + " " + gender + " " + major + " " + grade);
		for (Course c : courses) {
			c.showCourseWithOutStudents();
		}
	}
	
	//���ѧ����Ϣ����������ѡ�γ̡�
	public void showStudentWithOutCourses() {
		System.out.println("Studen����: " + id + " " + name + " " + gender + " " + major + " " + grade);
	}
}
