package com.briup.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.briup.annotation.Person;


public interface AnnotationMapper {
	
	//ע��д���Ժ󣬾Ͳ���Ҫ�������ļ���дinsert��ǩ��
	@Insert("insert into person(id,name,age) values(#{id},#{name},#{age})")
	public void insertPerson(Person p);
	
	//��������Զ���������
	@Insert("insert into person(id,name,age) values(#{id},#{name},#{age})")
	@SelectKey(statement="select my_seq.nextval from dual",resultType=int.class,keyProperty="id",before=true)
	public void insertPersonAutoId(Person p);

	@Update("update person set name=#{name},age=#{age} where id=#{id}")
	public void updatePerson(Person p);
	
	@Delete("delete from person where id=#{id}")
	public void deletePerson(int id);
	
	@Select("select id,name,age from person where id=#{id}")
	public Person selectPersonById(int id);
	
	@Select("select * from person")
	public List<Person> selectAllPerson();
	
	//��������ӳ����
	@Select("select id as pid,name,age from person")
	@Results({
		@Result(id=true,property="id",column="pid"),
		@Result(property="name",column="name"),
		@Result(property="age",column="age")
	})
	public List<Person> selectAllPerson_ResultMap();

	//ʹ��xml��ע�� ��� ʵ�����ù���
/*	@Select("select id as pid,name,age from person")
	@ResultMap("com.briup.mybatis.PersonResult")
	public List<Person> selectAllPerson_ResultMap_XML();*/
	
}