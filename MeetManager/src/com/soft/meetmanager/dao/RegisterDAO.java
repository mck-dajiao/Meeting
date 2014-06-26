package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.soft.meetmanager.model.Employee;
import com.soft.meetmanager.util.ConnectionFactory;

public class RegisterDAO {
  public int insertuser(Employee ee){
	  int i=0;
	  Connection conn=ConnectionFactory.getConnection();
	  String sql="insert into employee"
			  +
				"(employeename,username,password,phone,email,departmentid,status)" +
				" values(?,?,?,?,?,?,?)";
	  try {
		 String s="Œ¥…Û≈˙";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,ee.getEmployeename());
		pstmt.setString(2, ee.getUsername());
		pstmt.setString(3,ee.getPassword() );
		pstmt.setString(4,ee.getPhone());
		pstmt.setString(5,ee.getEmail());
		pstmt.setInt(6, ee.getDepartmentid());
		pstmt.setString(7,s);
		i=pstmt.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return i;
  }
  
}
