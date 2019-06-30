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
 * 测试类    导包ctrl+shift+o
 */
public class StudentMapperTest {
	
	//junit-4.7.jar 单元测试
	@Test
	public void test() {
		System.out.println("hello world");
	}
	
	@Test
	public void test_getAllNames() {
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			//通过session执行sql语句
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
			
			//通过session执行sql语句
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
			
			//通过session执行sql语句
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
			//1.获取session对象
			SqlSession session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取映射对象
			StudentMapper mapper = session.getMapper(StudentMapper.class);
			
			//3.执行方法
			List<Student> list = mapper.findAllStudents();
			for (Student s : list) {
				System.out.println(s);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//测试查询功能
	@Test
	public void test_select() {
		try {
			//1.获取sqlSession对象
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
			
			//2.获取 接口实现类对象[通过Mybatis底层的动态代理] 
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			//3.根据id获取数据库表中一行数据，并且转换成对象
			Student stu = mapper.findStudentById(1);
			System.out.println(stu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main3(String[] args) {
		try {
			//1.获取sqlSession对象
			InputStream inputStream = 
					Resources.getResourceAsStream("mybatis-config.xml"); 
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//2.获取 接口实现类对象[通过Mybatis底层的动态代理] 
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			//3.通过接口引用，调用方法实现功能
			mapper.deleteStudent(1);
			
			//4.提交事务
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main2(String[] args) {
		try {
			//1.获取sqlSession对象
			InputStream inputStream = 
					Resources.getResourceAsStream("mybatis-config.xml"); 
			SqlSessionFactory sqlSessionFactory = 
					new SqlSessionFactoryBuilder().build(inputStream);
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			//2.获取 接口实现类对象[通过Mybatis底层的动态代理] 
			StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
			
			//3.通过接口引用，调用方法实现功能
			mapper.updateStudent(new Student(1,"jack","jack@163.com",new Date()));
			
			//4.提交事务
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test_insert() throws IOException {
		//1.整合配置文件 获取一个SqlSession对象
		InputStream inputStream = 
				Resources.getResourceAsStream("mybatis-config.xml"); 
		SqlSessionFactory sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//2.借助SqlSession对象 获取 映射接口的实现类对象
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		Student s = new Student(1,"tom","123@briup.com",new Date());
		
		//3.通过接口的应用 调用 方法，实现对象-表的映射，借助映射文件 sql语句
		studentMapper.insertStudent2(s);
		sqlSession.commit();
	}
}






