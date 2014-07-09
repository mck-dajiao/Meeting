package com.dajiao.service;

import java.util.List;

import com.dajiao.dao.DepartmentManagerDAO;
import com.dajiao.model.Department;

public class AdDepartmentService {

	public AdDepartmentService() {
		// TODO Auto-generated constructor stub
	}

	public static boolean newDepartment(int departmentId, String name){
		Department department = new Department();
		department.setId(departmentId);
		department.setName(name);
		
		return DepartmentManagerDAO.addDepartment(department);
	}
	
	public static List<Department> getDepartmentList(){
		return DepartmentManagerDAO.getAllDepartment();
	}
	
	public static boolean deleteDepartment(String[] value){
		return DepartmentManagerDAO.deleteDepartment(value);
	}
}
