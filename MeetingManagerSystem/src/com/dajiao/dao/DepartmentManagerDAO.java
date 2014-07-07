package com.dajiao.dao;

import java.util.List;

import com.dajiao.model.Department;

public class DepartmentManagerDAO {

	public DepartmentManagerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Department> getAllDepartment(){
		// 获得所有的部门信息
		return null;
	}

	public static boolean modifyDepartment(Department department){
		// 修改部门信息
		return false;
	}
	
	public static boolean deleteDepartment(int id){
		// 删除部门，删除前确保部门没人
		return false;
	}
	
	public static boolean addDepartment(Department department){
		// 添加部门,确保名字不重复
		return false;
	}
}
