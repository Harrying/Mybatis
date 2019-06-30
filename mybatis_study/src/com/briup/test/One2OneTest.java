package com.briup.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Address;
import com.briup.bean.PhoneNumber;
import com.briup.bean.Student;
import com.briup.mappers.One2OneMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

/*
 * һ��һӳ�������
 */
public class One2OneTest {

	@Test
	public void test_insertStudentWithAddress() {
		SqlSession session = null;
		
		try {
			//1.��ȡsession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡӳ�����
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.��Ӷ��� students��
			PhoneNumber phone = new PhoneNumber("12-34-09");
			
			//�������������
			Address addr = new Address(3, "gq", "suzhou", "hq", "215300", "china");
			Student stu = new Student(3, "zs", "zs@briup.com", new Date(), phone, addr);
			
			//��students���в�������֮ǰ�ȿ� addr�Ƿ��Ѿ�����
			//����Ѿ�����ֱ�Ӳ���stu,�����Ȳ���addr,�ٲ���stu;
			Integer addr_Id = addr.getAddrId();
			Address addr2 = mapper.findAddressById(addr_Id);
			if(addr2 == null) {
				mapper.insertAddress(addr);
			}
			mapper.insertStudentWithAddress(stu);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_findStudentByIdWithoutAddress() {
		SqlSession session = null;
		
		try {
			//1.��ȡsession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡӳ�����
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.��ȡ���ж���
			Student stu = mapper.findStudentByIdWithoutAddress(1);
			System.out.println("stu: " + stu);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	@Test
	public void test_findAllStudents() {
		SqlSession session = null;
		
		try {
			//1.��ȡsession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡӳ�����
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.��ȡ���ж���
			List<Student> list = mapper.findAllStudents();
			System.out.println("size: " + list.size());
			for (Student stu : list) {
				System.out.println(stu);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	@Test
	public void test_findStudentById() {
		SqlSession session = null;
		
		try {
			//1.��ȡsession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡӳ�����
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.��ȡ���ж���
			Student stu = mapper.findStudentById(1);
			System.out.println("stu: " + stu);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_findAllAddresses() {
		SqlSession session = null;
		
		try {
			//1.��ȡsession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡӳ�����
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.��ȡ���ж���
			List<Address> list = mapper.findAllAddresses();
			System.out.println("size: " + list.size());
			for (Address addr : list) {
				System.out.println(addr);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	@Test
	public void test_findAddressById() {
		SqlSession session = null;
		
		try {
			//1.��ȡsession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡӳ�����
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.ͨ��ӳ����� ���� ����
			Address addr = mapper.findAddressById(1);
			System.out.println("addr: " + addr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
}
