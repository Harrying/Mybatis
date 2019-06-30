package com.briup.many2many;

import java.util.List;

public interface Many2ManyMapper {
	//插入student数据怕【借助 自动生成主键my_seq】
	public int insertStudent(Student student);
	//插入course数据
	public int insertCourse(Course c);
	
	//通过id查询学生
	public Student getStudentById(Integer id);
	//通过id查询课程
	public Course getCourseById(Integer id);
	
	//学生x选课y
	public void studentSelectCourse(Student student, Course course);
	
	//查询比指定id值小的学生信息
	public List<Student> getStudentByIdOnCondition(Integer id);
	
	//查询student级联查询出所选的course并且组装成完整的对象
	public Student getStudentByIdWithCourses(Integer id);
	
	//根据课程编号  查找所有选这门课的学生
	public List<Student> findAllStudentsByCourseId(Integer id);
	
	//根据课程的编号 获取课程信息【包含所选学生】
	public Course getCourseByIdWithStudents(Integer cid);
	
	
	
}







