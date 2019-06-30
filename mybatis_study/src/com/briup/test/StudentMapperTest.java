package com.briup.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.briup.mappers.StudentMapper;
import com.briup.pojo.Student;
import com.briup.utils.MyBatisSqlSessionFactory;

/*
 * ������    ����ctrl+shift+o
 */
public class StudentMapperTest {
	
	//junit-4.7.jar ��Ԫ����
	@Test
	public void test() {
		System.out.println("hello world");
	}
	
	@Test
	public void test_getAllNames() {
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			//ͨ��sessionִ��sql���
			List<String> list= session.selectList("com.briup.mappers.StudentMapper.getAllNames");
			for (String string : list) {
				System.out.println(string);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_getNameById() {
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			//ͨ��sessionִ��sql���
			String name = session.selectOne("com.briup.mappers.StudentMapper.getNameById",2);
			System.out.println("name: " + name);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_getStudentSize() {
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			//ͨ��sessionִ��sql���
			int num = session.selectOne("com.briup.mappers.StudentMapper.getStudentSize");
			System.out.println("num: " + num);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_selectStudentById_Map() {
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			
			Map<String, Object> map = mapper.findStudentById_Map(1);
			System.out.println("map.type: " + map.getClass().getName());
			for (String key : map.keySet()) {
				System.out.println(key + ": " + map.get(key));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
	}
	
	@Test
	public void test_findAllStudent_Map() {
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			
			List<Map<String, Object>> list = mapper.findAllStudent_Map();
			System.out.println("list.size: " + list.size());
			
			for (Map<String, Object> map : list) {
				System.out.println(map);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_selectAll() {
		try{
			//1.��ȡsession����
			SqlSession session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡӳ�����
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			
			//3.ִ�з���
			List<Student> list = mapper.findAllStudents();
			for (Student s : list) {
				System.out.println(s);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//���Բ�ѯ����
	@Test
	public void test_select() {
		try {
			//1.��ȡsqlSession����
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡ �ӿ�ʵ�������[ͨ��Mybatis�ײ�Ķ�̬����] 
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			//3.����id��ȡ���ݿ����һ�����ݣ�����ת���ɶ���
			Student stu = mapper.findStudentById(1);
			System.out.println(stu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main3(String[] args) {
		try {
			//1.��ȡsqlSession����
			InputStream inputStream = 
					Resources.getResourceAsStream("mybatis-config.xml"); 
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//2.��ȡ �ӿ�ʵ�������[ͨ��Mybatis�ײ�Ķ�̬����] 
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			//3.ͨ���ӿ����ã����÷���ʵ�ֹ���
			mapper.deleteStudent(1);
			
			//4.�ύ����
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main2(String[] args) {
		try {
			//1.��ȡsqlSession����
			InputStream inputStream = 
					Resources.getResourceAsStream("mybatis-config.xml"); 
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//2.��ȡ �ӿ�ʵ�������[ͨ��Mybatis�ײ�Ķ�̬����] 
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			//3.ͨ���ӿ����ã����÷���ʵ�ֹ���
			mapper.updateStudent(new Student(1,"jack","jack@163.com",new Date()));
			
			//4.�ύ����
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_insert() throws IOException {
		//1.���������ļ� ��ȡһ��SqlSession����
		InputStream inputStream = 
				Resources.getResourceAsStream("mybatis-config.xml"); 
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//2.����SqlSession���� ��ȡ ӳ��ӿڵ�ʵ�������
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student s = new Student(1,"tom","123@briup.com",new Date());
		
		//3.ͨ���ӿڵ�Ӧ�� ���� ������ʵ�ֶ���-���ӳ�䣬����ӳ���ļ� sql���
		studentMapper.insertStudent2(s);
		sqlSession.commit();
	}
}






