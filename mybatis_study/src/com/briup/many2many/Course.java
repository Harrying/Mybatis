package com.briup.many2many;

import java.util.List;

public class Course {
	private Integer id;
	private String courseCode; // �γ̱��
	private String courseName;// �γ�����
	// ѡ��ѧ��
	private List<Student> students;
	
	//mybatis�ײ� ���� �޲ι�����
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
	
	//����γ���Ϣ��������ѡ�ε�ѧ����
	public void showCourseWithOutStudents() {
		System.out.println("Course������Ϣ: " + id + " " + courseCode + " " + courseName);
	}
	
	//����γ���Ϣ������ѡ�ε�ѧ����
	public void showCourseWithStudents() {
		System.out.println("Course������Ϣ: " + id + " " + courseCode + " " + courseName);
		for (Student s : students) {
			s.showStudentWithOutCourses();
		}
	}
	
}








