package com.briup.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * ������ ������
 * 	���Ĺ���: ��ȡSqlSession����
 * 	��������ģʽ
 */
public class MyBatisSqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	
	//˽�й�����
	private MyBatisSqlSessionFactory() {}
	
	//�������ܣ�˽��
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
	
	//��ȡsqlSession����
	public static SqlSession openSession() { 
		return openSession(false); 
	}
	
	public static SqlSession openSession(boolean autoCommit) { 
		//										�Ƿ��Զ��ύ����
		return getSqlSessionFactory().openSession(autoCommit); 
	}
}






