package com.briup.mappers;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import com.briup.special.User;
import com.briup.special.UserPic;

public interface SpecialMapper {
	public void insertUser(User user);
	
	public User findUserById_test(Integer id);
	
	public void insertUserPic(UserPic userPic);
	
	public UserPic getUserPicById(Integer id);
	
	public List<User> findAllUserByNameGender(String name,String gender);
	
	public List<User> findAllUsers();
	
	public Map<String, Object> findUserById_Map(int id);
	
	//具备分页处理功能
	public List<User> findAllUsers(RowBounds rowBounds);
	
	public User findUserById(Integer id);
}
