package com.briup.mappers;

import java.util.List;
import java.util.Map;

import com.briup.bean.Course;


public interface DynamicSqlMapper {
	public List<Course> searchCourses(Map<String, Object> map); 
	
	public void updateCourse(Course course); 

}