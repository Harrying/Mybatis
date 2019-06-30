package com.briup.mappers;

import java.util.List;

import com.briup.bean.Address;
import com.briup.bean.Student;

/*
 * һ��һ ӳ��ӿ�
 */
public interface One2OneMapper {
	//���ݵ�ַ���  ��ȡ��ַ����
	public abstract Address findAddressById(int id);
	
	//��ȡ���е�ַ����
	public abstract List<Address> findAllAddresses();
	
	//��ȡһ��ѧ�����󡾰�����ַ��Ϣ��
	public abstract Student findStudentById(int id);

	//��ѯ�ö�����ѧ�����󡾰�����ַ��
	public abstract List<Student> findAllStudents();
	
	//Ƕ�׽����ѯ ��ȡ ѧ������
	public abstract Student findStudentByIdWithoutAddress(int id);
	
	//�����ַ��Ϣ
	public abstract void insertAddress(Address addr);
	
	//����ѧ����Ϣ
	public abstract void insertStudentWithAddress(Student stu);
}






