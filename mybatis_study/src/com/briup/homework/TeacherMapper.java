package com.briup.homework;

import java.util.List;

/*
 * 映射接口
 */
public interface TeacherMapper {

	//往数据库中插入一个老师对象   ps.
	//			ps.execute() ps.executeUpdate() ps.executeQuery()	
	public abstract void insertTeacher(Teacher t);
	
	//使用my_seq.nextval替代 老师id
	public abstract void insertTeacher_autoId(Teacher t);
	
	//常规方式 自动生成主键
	public abstract void insertTeacher_autoId2(Teacher t);
	
	//程序员 根据具体查询的结果  自己指定返回值类型
	public abstract List<Teacher> selectTeacherByName(String name);
	
	//底层借助 ResultMap完成映射
	public abstract List<Teacher> selectTeacherByName2(String name);
	
	//根据id查询老师信息 封装到teacher对象
	public abstract Teacher selectTeacherById(int id);
	
	//更新
	public abstract int updateTeacher(Teacher t);
	
	//删除
	//public abstract int deleteTeacherById(int id);
}






