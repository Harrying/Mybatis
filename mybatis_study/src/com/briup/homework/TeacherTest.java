package com.briup.homework;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.pojo.PhoneNumber;
import com.briup.utils.MyBatisSqlSessionFactory;

public class TeacherTest {
	
	@Test
	public void test_deleteTeacherById() {
		SqlSession session = null;
		try {
			//1.��ȡsqlSession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//���Ĺ��ܡ�ͨ��sessionֱ�� ִ��sql��䡿
			//session.delete("namespace.idֵ", ���ݲ���);
			int num = 
					session.delete("TeacherMapper.deleteTeacherById", 19);
			System.out.println("num: " + num);
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_selectTeacherById() {
		//org.apache.ibatis.logging.LogFactory.useJdkLogging(); 
		SqlSession session = null;
		try {
			//1.��ȡsqlSession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��session���� ��ȡ mapper����
			TeacherMapper mapper = session.getMapper(TeacherMapper.class);

			//3.
			Teacher t = mapper.selectTeacherById(14);
			System.out.println("t: " + t);
			System.out.println(t.getAddr());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_updateTeacher() {
		SqlSession session = null;
		try {
			//1.��ȡsqlSession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��session���� ��ȡ mapper����
			TeacherMapper mapper = session.getMapper(TeacherMapper.class);
			
			//3.����mapper����ʵ�ֹ���
			PhoneNumber phone = new PhoneNumber("sz-gq-23");
			Teacher t = new Teacher(14, "rose", 234.1, null, phone);
			int num = mapper.updateTeacher(t);
			System.out.println("num: " + num);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	@Test
	public void test_selectByName2() {
		SqlSession session = null;
		try {
			//1.��ȡsqlSession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��session���� ��ȡ mapper����
			TeacherMapper mapper = session.getMapper(TeacherMapper.class);
			
			//3.����mapper����ʵ�ֹ���
			List<Teacher> list = mapper.selectTeacherByName2("lucy");
			
			System.out.println("list.size: " + list.size());
			for (Teacher t : list) {
				System.out.println(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_selectByName() {
		SqlSession session = null;
		try {
			//1.��ȡsqlSession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��session���� ��ȡ mapper����
			TeacherMapper mapper = session.getMapper(TeacherMapper.class);
			
			//3.����mapper����ʵ�ֹ���
			List<Teacher> list = mapper.selectTeacherByName("lucy");
			
			System.out.println("list.size: " + list.size());
			for (Teacher t : list) {
				System.out.println(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_insert_autoId2() {
		
		SqlSession session = null;
		try {
			//1.��ȡsqlSession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��session���� ��ȡ mapper����
			TeacherMapper mapper = session.getMapper(TeacherMapper.class);
			
			//3.����mapper����ʵ�ֹ���
			Teacher t = new Teacher("lucy", 4531.2, new Date());
			mapper.insertTeacher_autoId2(t);
			//System.out.println(t.getTid());
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
	}
	
	@Test
	public void test_insert_autoId() {
		
		SqlSession session = null;
		try {
			//1.��ȡsqlSession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��session���� ��ȡ mapper����
			TeacherMapper mapper = session.getMapper(TeacherMapper.class);
			
			//3.����mapper����ʵ�ֹ���
			Teacher t = new Teacher(2, "lily", 2453.6, new Date());
			mapper.insertTeacher_autoId(t);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
	}

	@Test
	public void test_insert() {
		
		SqlSession session = null;
		try {
			//1.��ȡsqlSession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��session���� ��ȡ mapper����
			TeacherMapper mapper = session.getMapper(TeacherMapper.class);
			
			//3.����mapper����ʵ�ֹ���
			Teacher t = new Teacher(2, "tom", 4450.9, new Date());
			mapper.insertTeacher(t);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
	}
}
