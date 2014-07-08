package com.dajiao.dao;

import java.util.List;

import com.dajiao.model.User;

public class EmployeeManagerDAO {

	public EmployeeManagerDAO() {
		// TODO Auto-generated constructor stub
	}

	public static List<User> getAllUser(){
		return null;
	}
	
	public static List<User> getUser(int num){
		// 获取数据库中前num个数据
		return null;
	}
	
	public static List<User> getUserByName(String name){
		// 根据名字获取用户列表
		return null;
	}
	
	public static User getUserById(int id){
		// 通过id找用户
		return null;
	}
	
	public static List<User> getUserByDepartmentName(String departmentName){
		// 根据部门获取用户列表
		return null;
	}
	
	public static boolean deleteUser(String account){
		// 删除用户
		return false;
	}
	
	public static boolean addUser(User user){
		// 添加用户
		return false;
	}
	
	public static boolean modify(User user){
		// 修改用户
		return false;
	}
	
	public static boolean deleteUser(String[] userList){
		// 字符串数组
		return false;
	}
	
}
