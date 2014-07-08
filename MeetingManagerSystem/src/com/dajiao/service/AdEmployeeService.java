package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.EmployeeManagerDAO;
import com.dajiao.model.User;

public class AdEmployeeService {

	public AdEmployeeService() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean deleteUser(String[] userList){
		return  EmployeeManagerDAO.deleteUser(userList);
	}

	public static List<User> getUserList(String name, String userId, String department){
		return null;
	}
}
