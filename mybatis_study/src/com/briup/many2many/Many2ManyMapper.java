package com.briup.many2many;

import java.util.List;

public interface Many2ManyMapper {
	//����student�����¡����� �Զ���������my_seq��
	public int insertStudent(Student student);
	//����course����
	public int insertCourse(Course c);
	
	//ͨ��id��ѯѧ��
	public Student getStudentById(Integer id);
	//ͨ��id��ѯ�γ�
	public Course getCourseById(Integer id);
	
	//ѧ��xѡ��y
	public void studentSelectCourse(Student student, Course course);
	
	//��ѯ��ָ��idֵС��ѧ����Ϣ
	public List<Student> getStudentByIdOnCondition(Integer id);
	
	//��ѯstudent������ѯ����ѡ��course������װ�������Ķ���
	public Student getStudentByIdWithCourses(Integer id);
	
	//���ݿγ̱��  ��������ѡ���ſε�ѧ��
	public List<Student> findAllStudentsByCourseId(Integer id);
	
	//���ݿγ̵ı�� ��ȡ�γ���Ϣ��������ѡѧ����
	public Course getCourseByIdWithStudents(Integer cid);
	
	
	
}







