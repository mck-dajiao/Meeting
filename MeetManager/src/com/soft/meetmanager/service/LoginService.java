package com.soft.meetmanager.service;

import com.soft.meetmanager.dao.LoginDAO;
import com.soft.meetmanager.model.Employee;

public class LoginService {
	Employee emp = new Employee();
	public int getDet(Employee emp){
		
		LoginDAO LA=new LoginDAO();
		 int i=LA.believe(emp);
		
		return i;
	}
	
	
	//查看个人详细信息
	public Employee getDetail(String username){
		Employee emp = new Employee();
		
		LoginDAO lgdao = new LoginDAO();
		emp = lgdao.getid(username);
		return emp;
	}
}
