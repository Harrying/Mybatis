package com.briup.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.briup.pojo.Student;

/*
 * ӳ��ӿ� ��������ķ�����sql��� ��
 */
public interface StudentMapper {
	
	//���庯���ķ���ֵ�����û��Լ�����
	//��������ķ���ֵ ��List<����>����ӳ���ļ� sql����� resultType="����";
	public List<Student> findAllStudents();
	
	//ע��: ��������뷵��һ�� List���ϣ���resultTypeӦ��дlist��ų�Ա������
	//	List��mybatisʮ�����⣬����resultType="list" ERROR
	//���Ҫ���ض������resultType="map" ���Զ�����List������
	public List<Map<String,Object>> findAllStudent_Map();
	
	public Student findStudentById(Integer id);
	
	//��ѯһ��ѧ����Ϣ  ӳ�䵽 map������
	public Map<String,Object> findStudentById_Map(Integer id);
	public List<Object> findStudentById_List(Integer id);
	
	//��student���� ��ӵ����ݿ����
	public void insertStudent2(Student stu);
	
	public abstract void updateStudent(Student s);
	
	public abstract void deleteStudent(int id);
	
	//��ȡ���ݿ��� ѧ������
	public abstract int getStudentSize();
	
	public abstract String getNameById();
	
	public abstract List<String> getAllNames();
}







