package com.briup.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.annotation.Person;
import com.briup.mappers.AnnotationMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

public class AnnotationsMapperTest {

	@Test
	public void test_insertPerson() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
		
		mapper.insertPerson(new Person(3,"lucy",21));
		session.commit();
	}
	
	@Test
	public void test_insertPersonAutoId() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
		
		//自动生成id值
		mapper.insertPersonAutoId(new Person("tom",32));
		session.commit();
	}
	
	@Test
	public void test_updatePerson() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);

		mapper.updatePerson(new Person(44,"lily",20));
		session.commit();
	}
	
	@Test
	public void test_deletePerson() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);

		mapper.deletePerson(44);
		session.commit();
	}
	
	@Test
	public void test_selectPersonById() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);

		Person person = mapper.selectPersonById(3);
		System.out.println(person);
		session.commit();
	}
	
	@Test
	public void test_selectAllPerson() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);

		List<Person> list = mapper.selectAllPerson();
		for(Person p:list)
			System.out.println(p);
		
		session.commit();
	}
	

	@Test
	public void test_selectAllPerson_ResultMap() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
		List<Person> list = mapper.selectAllPerson_ResultMap();
		for(Person p:list)
			System.out.println(p);
		
		session.commit();
	}
	
/*	@Test
	public void test_selectAllPerson_ResultMap_XML() {
		SqlSession session = null;
		session = MyBatisSqlSessionFactory.openSession();
		
		AnnotationMapper mapper = session.getMapper(AnnotationMapper.class);
		List<Person> list = mapper.selectAllPerson_ResultMap_XML();
		for(Person p:list)
			System.out.println(p);
		
		session.commit();
	}*/
}
