package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soft.meetmanager.model.Department;
import com.soft.meetmanager.util.ConnectionFactory;

public class SelectDepartmentDAO {
    public List lookingdepartment(){
    	List list=new ArrayList();
    	Connection conn=ConnectionFactory.getConnection();
    	String sql="select departmentid,departmentname from department";
    	try {
			Statement stat=conn.createStatement();
			ResultSet rs =stat.executeQuery(sql);
			while(rs.next()){
				Integer departmentid=rs.getInt("departmentid");
				String departmentname=rs.getString("departmentname");
				Department dep=new Department(departmentid,departmentname);
				dep.setDepartmentid(departmentid);
				dep.setDepartmentname(departmentname);
				list.add(dep);
				System.out.println(departmentid);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  return list;
    }
  
}
