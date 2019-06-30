package com.briup.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.briup.bean.Address;
import com.briup.bean.PhoneNumber;
import com.briup.bean.Student;
import com.briup.mappers.One2OneMapper;
import com.briup.utils.MyBatisSqlSessionFactory;

/*
 * 一对一映射测试类
 */
public class One2OneTest {

	@Test
	public void test_insertStudentWithAddress() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取映射对象
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.添加对象到 students表
			PhoneNumber phone = new PhoneNumber("12-34-09");
			
			//考虑主外键关联
			Address addr = new Address(3, "gq", "suzhou", "hq", "215300", "china");
			Student stu = new Student(3, "zs", "zs@briup.com", new Date(), phone, addr);
			
			//往students表中插入数据之前先看 addr是否已经存在
			//如果已经存在直接插入stu,否则先插入addr,再插入stu;
			Integer addr_Id = addr.getAddrId();
			Address addr2 = mapper.findAddressById(addr_Id);
			if(addr2 == null) {
				mapper.insertAddress(addr);
			}
			mapper.insertStudentWithAddress(stu);
			
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_findStudentByIdWithoutAddress() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取映射对象
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.获取所有对象
			Student stu = mapper.findStudentByIdWithoutAddress(1);
			System.out.println("stu: " + stu);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	@Test
	public void test_findAllStudents() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取映射对象
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.获取所有对象
			List<Student> list = mapper.findAllStudents();
			System.out.println("size: " + list.size());
			for (Student stu : list) {
				System.out.println(stu);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	@Test
	public void test_findStudentById() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取映射对象
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.获取所有对象
			Student stu = mapper.findStudentById(1);
			System.out.println("stu: " + stu);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void test_findAllAddresses() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取映射对象
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.获取所有对象
			List<Address> list = mapper.findAllAddresses();
			System.out.println("size: " + list.size());
			for (Address addr : list) {
				System.out.println(addr);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	@Test
	public void test_findAddressById() {
		SqlSession session = null;
		
		try {
			//1.获取session对象
			session = MyBatisSqlSessionFactory.openSession();
			
			//2.获取映射对象
			One2OneMapper mapper = session.getMapper(One2OneMapper.class);
			
			//3.通过映射对象 调用 方法
			Address addr = mapper.findAddressById(1);
			System.out.println("addr: " + addr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
}
