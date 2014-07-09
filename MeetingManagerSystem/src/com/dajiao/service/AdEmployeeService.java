package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.EmployeeManagerDAO;
import com.dajiao.model.User;

public class AdEmployeeService {

	public AdEmployeeService() {
		// TODO Auto-generated constructor stub
	}

	public static boolean deleteUser(String[] userList) {
		return EmployeeManagerDAO.deleteUser(userList);
	}

	public static List<User> getUserList(String name, String userid,
			String departmentname) {

		User user = EmployeeManagerDAO.getUserById(userid);
		
		List<User> list2 = EmployeeManagerDAO.getUserByName(name);
		
		List<User> list3 = EmployeeManagerDAO
				.getUserByDepartmentName(departmentname);

		if (list2.isEmpty()==false && list3.isEmpty()==false) {
			for (User u : list2) {
				if (list3.contains(u) == false) {
					list3.add(u);
				}
			}
		}

		if (user != null && list3.contains(user) == false)
			list3.add(user);

		if (user != null && list2.contains(user) == false) {
			list2.add(user);
		}

		return (list3.isEmpty()==true) ? list2 : list3;
	}
}
