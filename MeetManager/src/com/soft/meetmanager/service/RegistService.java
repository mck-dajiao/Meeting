package com.soft.meetmanager.service;

import com.soft.meetmanager.dao.RegisterDAO;
import com.soft.meetmanager.model.Employee;

public class RegistService {
	Employee ee=new Employee();
	public void regist(Employee ee){
	RegisterDAO rtdao=new RegisterDAO();
	rtdao.insertuser(ee);
	}
}
