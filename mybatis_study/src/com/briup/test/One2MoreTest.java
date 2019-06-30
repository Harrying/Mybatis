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
			//1.��ȡsession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡmapper����
			One2MoreMapper mapper = session.getMapper(One2MoreMapper.class);
			
			//3.ͨ��mapper������ɹ���
			//	[��ȥ�ж� �Ƿ���������� 2�� ��ʦ]
			// ֱ�ӽ�course���� 2����ʦ���Ŀγ� �޸�tutor_idΪnull
			mapper.updateCourseSetTutorIdNull(2);
			
			//��ʱ����ֱ��ɾ�� tutor��������
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
			//1.��ȡsession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡmapper����
			One2MoreMapper mapper = session.getMapper(One2MoreMapper.class);
			
			//3.ͨ��mapper������ɹ���
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
			//1.��ȡsession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡmapper����
			One2MoreMapper mapper = session.getMapper(One2MoreMapper.class);
			
			//3.ͨ��mapper������ɹ���
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
			//1.��ȡsession����
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.��ȡmapper����
			One2MoreMapper mapper = session.getMapper(One2MoreMapper.class);
			
			//3.ͨ��mapper������ɹ���
			Tutor t = mapper.findTutorByIdWithCourses(1);
			System.out.println(t);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
}








