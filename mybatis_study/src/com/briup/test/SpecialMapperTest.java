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
	
	//测试mybatis对枚举类型的支持
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
	
	//测试mybatis处理CLOB/BLOB类型数据  保存数据
	@Test
	public void test_insertUserPic(){
		byte[] pic = null; 
		try {
			//读取图片src/com/briup/special/test.png
			File file = new File("src/com/briup/special/test.png"); 
			InputStream is = new FileInputStream(file); 
			pic = new byte[is.available()]; 
			is.read(pic); 
			is.close(); 
		} catch (Exception e){ 
			e.printStackTrace(); 
		} 
		String name = "tom"; 
		String bio = "可以是很长的字符";
		//建立对象
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
	
	//测试mybatis处理CLOB/BLOB类型数据  查询里面数据
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
	
	//传入多个参数
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
	
	//测试mybatis多行结果集映射成Map
	@Test
	public void test_findAllUsers(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			Map<Integer, User> map = 								//   指定map中key的取值
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
	
	//测试mybatis使用RowBounds对结果集进行分页
	@Test
	public void test_RowBounds(){
		
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			
			//偏移量为2
			int offset = 2;
			//只获取3条
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
	
	//测试mybatis使用ResultSetHandler自定义结果集ResultSet处理
	@Test
	public void test_ResultHandler(){
		//a.自定义集合
		final Map<Integer,String> map = new HashMap<Integer, String>(); 
		SqlSession session = null;
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			//b.调用select方法，传入(命名空间名.方法名,匿名内部类对象);
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
	
	//测试mybatis缓存  一级缓存【当session进行commit或close后，缓存会被关闭】
	//【注意，不可以在根元素下添加  <cache/>标签】
	@Test
	public void test_cache1(){
		SqlSession session = null;
		
		try {
			session = MyBatisSqlSessionFactory.openSession();
			
			SpecialMapper mapper = session.getMapper(SpecialMapper.class);
			
			User user1 = mapper.findUserById(40);
			System.out.println(user1);
			
			//commit提交后 清空mybatis自带一级缓存
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
	
	//测试mybatis缓存  二级缓存
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
			
			//必须提交 才能放入二级缓存
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

