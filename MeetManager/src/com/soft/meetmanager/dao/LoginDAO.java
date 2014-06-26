package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.soft.meetmanager.model.Employee;
import com.soft.meetmanager.util.ConnectionFactory;

public class LoginDAO {
 public int believe(Employee emp){
	 int i=0;
	 Connection conn=ConnectionFactory.getConnection();
	 try {
		 PreparedStatement st=null;
		String sql="select * from employee where username='"+emp.getUsername()+"' and  password='"+emp.getPassword()+"'";
 		st = conn.prepareStatement(sql);
		ResultSet rs =st.executeQuery(sql);
		if(rs.next()==true){
 			i=1;
		}else{
 			i=0;
		}
	 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 return i;
 }
 public Employee getid(String username){
	 Employee employee=new Employee();
	 Connection conn=ConnectionFactory.getConnection();
	 try {

		String sql="select employeeid,phone,departmentid,employeename,username,email,password,role  from employee where username='"+username+"'";
		PreparedStatement state=conn.prepareStatement(sql);
		ResultSet rs=state.executeQuery();
		if(rs.next()){
			employee.setEmployeeid(rs.getInt("employeeid"));
			employee.setDepartmentid(rs.getInt("departmentid"));
			employee.setEmail(rs.getString("email"));
			employee.setPhone(rs.getString("phone"));
			employee.setPassword(rs.getString("password"));
			employee.setEmployeename(rs.getString("employeename"));
			employee.setUsername(rs.getString("username"));
			employee.setRole(rs.getString("role"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	return  employee;
 }
 
}
