package com.briup.homework;

import java.util.List;

/*
 * ӳ��ӿ�
 */
public interface TeacherMapper {

	//�����ݿ��в���һ����ʦ����   ps.
	//			ps.execute() ps.executeUpdate() ps.executeQuery()	
	public abstract void insertTeacher(Teacher t);
	
	//ʹ��my_seq.nextval��� ��ʦid
	public abstract void insertTeacher_autoId(Teacher t);
	
	//���淽ʽ �Զ���������
	public abstract void insertTeacher_autoId2(Teacher t);
	
	//����Ա ���ݾ����ѯ�Ľ��  �Լ�ָ������ֵ����
	public abstract List<Teacher> selectTeacherByName(String name);
	
	//�ײ���� ResultMap���ӳ��
	public abstract List<Teacher> selectTeacherByName2(String name);
	
	//����id��ѯ��ʦ��Ϣ ��װ��teacher����
	public abstract Teacher selectTeacherById(int id);
	
	//����
	public abstract int updateTeacher(Teacher t);
	
	//ɾ��
	//public abstract int deleteTeacherById(int id);
}






