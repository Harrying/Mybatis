package com.briup.test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.mappers.DynamicSqlMapper;
import com.briup.bean.Course;
import com.briup.utils.MyBatisSqlSessionFactory;


public class DynamicSqlMapperTest {
	
	@Test
	public void test_searchCourses_if(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>(); 
			map.put("tutorId", 1); 
//			map.put("courseName", null); 
//			map.put("courseName", "%Java%"); 
			Date d = new Date();
			long time = d.getTime();
			long t2 = time - (long)1000*60*60*24*365*4;
			map.put("startDate", new Date(t2));
			
			List<Course> list = mapper.searchCourses(map);
			
			for(Course c:list){
				System.out.println(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	@Test
	public void test_searchCourses_choose(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>(); 
			map.put("tutorId", 1); 
			map.put("courseName", "%Java%"); 
			
			map.put("searchBy", "Tutor");
//			map.put("searchBy", "CourseName");
			
			List<Course> list = mapper.searchCourses(map);
			
			for(Course c:list){
				System.out.println(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	@Test
	public void test_searchCourses_where(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>(); 
//			map.put("tutorId", 1); 
			map.put("courseName", "%Java%"); 
			
			List<Course> list = mapper.searchCourses(map);
			
			for(Course c:list){
				System.out.println(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	@Test
	public void test_searchCourses_trim(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>(); 
			map.put("tutorId", 1); 
			map.put("courseName", "%Java%"); 
			
			List<Course> list = mapper.searchCourses(map);
			
			for(Course c:list){
				System.out.println(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	@Test
	public void test_searchCourses_foreach(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Map<String,Object> map = new HashMap<String,Object>(); 
			
			map.put("tutorIds", Arrays.asList(1,3,5,7));
			
			List<Course> list = mapper.searchCourses(map);
			
			for(Course c:list){
				System.out.println(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
		
	}
	
	@Test
	public void test_searchCourses_set(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
			
			Course course = new Course();
			course.setCourseId(3);
			course.setName("OOAD");
			course.setDescription("OOAD");
			//course.setStartDate();
			//course.setEndDate();
			
			mapper.updateCourse(course);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
		
	}

}
