package com.briup.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * 工具类 工厂类
 * 	核心功能: 获取SqlSession对象
 * 	懒汉单例模式
 */
public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	//私有构造器
	private MyBatisSqlSessionFactory() {}
	
	//辅助功能，私有
	private static SqlSessionFactory getSqlSessionFactory(){
		if(sqlSessionFactory == null){
			InputStream inputStream = null;
			try {
				inputStream = Resources.getResourceAsStream("mybatis-config.xml"); 
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getCause());
			}
		}
		return sqlSessionFactory;
	}
	
	//获取sqlSession对象
	public static SqlSession openSession() { 
		return openSession(false); 
	}
	
	public static SqlSession openSession(boolean autoCommit) { 
		//										是否自动提交事务
		return getSqlSessionFactory().openSession(autoCommit); 
	}
}






