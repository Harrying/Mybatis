package com.briup.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Course;
import com.briup.bean.Tutor;
import com.briup.mappers.One2MoreMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

public class One2MoreTest {
	
	@Test
	public void test_deleteTutorById_setNull() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			One2MoreMapper mapper = session.getMapper(One2MoreMapper.class);
			
			//3.通过mapper对象完成功能
			//	[先去判断 是否有外表引用 2号 老师]
			// 直接将course表中 2号老师讲的课程 修改tutor_id为null
			mapper.updateCourseSetTutorIdNull(2);
			
			//此时可以直接删除 tutor表中数据
			mapper.deleteTutorById_setNull(2);
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_findAllTutorsWithCourses() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			One2MoreMapper mapper = session.getMapper(One2MoreMapper.class);
			
			//3.通过mapper对象完成功能
			List<Tutor> list = mapper.findAllTutorsWithCourses();
			for (Tutor t : list) {
				System.out.println(t);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	//ctrl shift -|+
	@Test
	public void test_findCourseById() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			One2MoreMapper mapper = session.getMapper(One2MoreMapper.class);
			
			//3.通过mapper对象完成功能
			Course c = mapper.findCourseById(1);
			System.out.println(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_findTutorByIdWithCourses() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取mapper对象
			One2MoreMapper mapper = session.getMapper(One2MoreMapper.class);
			
			//3.通过mapper对象完成功能
			Tutor t = mapper.findTutorByIdWithCourses(1);
			System.out.println(t);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}








