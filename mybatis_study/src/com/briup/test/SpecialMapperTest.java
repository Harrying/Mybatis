package com.briup.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.mappers.SpecialMapper;
import com.briup.special.Gender;
import com.briup.special.User;
import com.briup.special.UserPic;
import com.briup.utils.MyBatisSqlSessionFactory;

public class SpecialMapperTest {
	
	//����mybatis��ö�����͵�֧��
	@Test
	public void test_insertUser(){
		
		SqlSession session = null;
		
		session = MyBatisSqlSessionFactory.openSession();
		
		SpecialMapper mapper = session.getMapper(SpecialMapper.class);
		
		User user = new User("zs",Gender.MALE);
		
		mapper.insertUser(user);
		session.commit();
	}
	
	@Test
	public void test_findUserById_test(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			
			User user = mapper.findUserById_test(41);
			
			System.out.println(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	//����mybatis����CLOB/BLOB��������  ��������
	@Test
	public void test_insertUserPic(){
		byte[] pic = null; 
		try {
			//��ȡͼƬsrc/com/briup/special/test.png
			File file = new File("src/com/briup/special/test.png"); 
			InputStream is = new FileInputStream(file); 
			pic = new byte[is.available()]; 
			is.read(pic); 
			is.close(); 
		} catch (Exception e){ 
			e.printStackTrace(); 
		} 
		String name = "tom"; 
		String bio = "�����Ǻܳ����ַ�";
		//��������
		UserPic userPic = new UserPic(name, pic, bio);
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			
			mapper.insertUserPic(userPic);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	//����mybatis����CLOB/BLOB��������  ��ѯ��������
	@Test
	public void test_getUserPicById(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			
			UserPic userPic = mapper.getUserPicById(43);
			
			System.out.println(userPic.getId());
			System.out.println(userPic.getName());
			System.out.println(userPic.getBio());
			System.out.println(userPic.getPic().length);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	//����������
	@Test
	public void test_findAllUserByNameGender() {
		SqlSession session = null;
		try{
			session = MyBatisSqlSessionFactory.openSession();
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			
			List<User> list = mapper.findAllUserByNameGender("tom", "MALE");
			for(User u:list) {
				System.out.println(u);
			}
			
			session.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//����mybatis���н����ӳ���Map
	@Test
	public void test_findAllUsers(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			Map<Integer, User> map = 								//   ָ��map��key��ȡֵ
					session.selectMap("com.briup.mappers.SpecialMapper.findAllUsers","id");
			for(Integer key:map.keySet()){
				System.out.println(key+" : "+map.get(key));
			}
			
//			Map<String, User> map = 
//					session.selectMap("com.briup.mappers.SpecialMapper.findAllUsers","name");
//			for(String key:map.keySet()){
//				System.out.println(key+" : "+map.get(key));
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	@Test
	public void test_findUserById_Map(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			Map<String, Object> map = mapper.findUserById_Map(41);
			for (String key : map.keySet()) {
				System.out.println(key + ": " + map.get(key));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	//����mybatisʹ��RowBounds�Խ�������з�ҳ
	@Test
	public void test_RowBounds(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			
			//ƫ����Ϊ2
			int offset = 2;
			//ֻ��ȡ3��
			int limit = 3; 
			RowBounds rowBounds = new RowBounds(offset, limit); 
			List<User> list = mapper.findAllUsers(rowBounds);
			
			for(User u:list){
				System.out.println(u);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)session.close();
		}
	}
	
	//����mybatisʹ��ResultSetHandler�Զ�������ResultSet����
	@Test
	public void test_ResultHandler(){
		//a.�Զ��弯��
		final Map<Integer,String> map = new HashMap<Integer, String>(); 
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			//b.����select����������(�����ռ���.������,�����ڲ������);
			session.select("com.briup.mappers.SpecialMapper.findAllUsers", new ResultHandler<User>() {
				@Override
				public void handleResult(ResultContext<? extends User> rc) {
					User u = rc.getResultObject();
					map.put(u.getId(), u.getName());
				}
			});
			
			for(Integer key:map.keySet()){
				System.out.println(key+" : "+map.get(key));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(session!=null)session.close();
		}

	}
	
	//����mybatis����  һ�����桾��session����commit��close�󣬻���ᱻ�رա�
	//��ע�⣬�������ڸ�Ԫ�������  <cache/>��ǩ��
	@Test
	public void test_cache1(){
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			
			User user1 = mapper.findUserById(40);
			System.out.println(user1);
			
			//commit�ύ�� ���mybatis�Դ�һ������
			//session.commit();
			
			User user2 = mapper.findUserById(40);
			System.out.println(user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(session!=null)session.close();
		}
	}
	
	//����mybatis����  ��������
	@Test
	public void test_cache2(){
		SqlSession session1 = null;
		SqlSession session2 = null;
		try {
			session1 = MyBatisSqlSessionFactory.openSession();
			session2 = MyBatisSqlSessionFactory.openSession();
			
			SpecialMapper mapper1 = session1.getMapper(SpecialMapper.class);
			SpecialMapper mapper2 = session2.getMapper(SpecialMapper.class);
			
			User user1 = mapper1.findUserById(40);
			System.out.println(user1);
			
			//�����ύ ���ܷ����������
			//session1.commit();
			
			User user2 = mapper2.findUserById(40);
			System.out.println(user2);
			session2.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session1!=null)session1.close();
			if(session2!=null)session2.close();
		}
	}
	
}

