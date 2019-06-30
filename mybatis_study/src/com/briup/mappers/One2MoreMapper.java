package com.briup.mappers;

import java.util.List;

import com.briup.bean.Course;
import com.briup.bean.Tutor;

public interface One2MoreMapper {
	public abstract Course findCourseById(int id);
	
	public abstract Tutor findTutorByIdWithCourses(int id);
	
	//ͨ��Ƕ�׽����ѯ ��ȡ������ʦ
	public abstract List<Tutor> findAllTutorsWithCourses();
	
	//ɾ��ָ��id����ʦ
	public abstract void deleteTutorById_setNull(int id);
	
	//��ָ����ʦ���Ŀγ� �� tutor_id �޸�Ϊnull
	public abstract void updateCourseSetTutorIdNull(int id);
	
	
}
