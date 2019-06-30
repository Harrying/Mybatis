package com.briup.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.many2many.Course;
import com.briup.many2many.Many2ManyMapper;
import com.briup.many2many.Student;
import com.briup.utils.MyBatisSqlSessionFactory;

public class Many2ManyTest {
	@Test
	public void test_getStudentByIdOnCondition() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			//3.
			List<Student> list = mapper.getStudentByIdOnCondition(27);
			for (Student stu : list) {
				stu.showStudentWithOutCourses();
			}
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_getCourseByIdWithStudents() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			//3.
			Course course = mapper.getCourseByIdWithStudents(29);
			course.showCourseWithStudents();
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_findAllStudentsByCourseId() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			//3.
			List<Student> list = mapper.findAllStudentsByCourseId(28);
			for (Student stu : list) {
				stu.showStudentWithOutCourses();
			}
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_getStudentByIdWithCourses() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			//3.
			Student stu = mapper.getStudentByIdWithCourses(25);
			stu.showStudentWithCourses();
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_studentSelectCourse() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			Student s = mapper.getStudentById(25);
			if(s == null)
				throw new Exception("无法获取学生");
			
			Course c = mapper.getCourseById(28);
			if(c == null)
				throw new Exception("无法获取课程");
			
			mapper.studentSelectCourse(s, c);
			
			session.commit();
			
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_getCourseById() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			//3.通过mapper对象 插入学生
			Course c = mapper.getCourseById(28);
			c.showCourseWithOutStudents();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_getStudentById() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			//3.通过mapper对象 插入学生
			Student stu = mapper.getStudentById(27);
			stu.showStudentWithOutCourses();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_insertCourse() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			//3.通过mapper对象 插入学生
			Course c = new Course("003", "css");
			int n = mapper.insertCourse(c);
			System.out.println("n: " + n);
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_insertStudent() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			Many2ManyMapper mapper = session.getMapper(Many2ManyMapper.class);
			
			//3.通过mapper对象 插入学生
			Student s = new Student("tom", "man", "rjkf", "a01");
			int n = mapper.insertStudent(s);
			System.out.println("n: " + n);
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}
