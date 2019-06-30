package com.briup.mappers;

import java.util.List;

import com.briup.bean.Course;
import com.briup.bean.Tutor;

public interface One2MoreMapper {
	public abstract Course findCourseById(int id);
	
	public abstract Tutor findTutorByIdWithCourses(int id);
	
	//通过嵌套结果查询 获取所有老师
	public abstract List<Tutor> findAllTutorsWithCourses();
	
	//删除指定id的老师
	public abstract void deleteTutorById_setNull(int id);
	
	//将指定老师讲的课程 中 tutor_id 修改为null
	public abstract void updateCourseSetTutorIdNull(int id);
	
	
}
