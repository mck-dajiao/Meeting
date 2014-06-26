package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.meetmanager.model.Employee;
import com.soft.meetmanager.util.ConnectionFactory;

public class EmpFenyeDao {
	
	public List<Employee> search(String username,String empname,int beginInt,int endInt){
		List<Employee> emplist = new ArrayList<Employee>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from (select rownum rm,employeeid," +
				"employeename,username,phone,email,departmentid," +
				"password from employee where username=?" +
				" and employeename=?) where rm between "+beginInt+
				" and "+endInt;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, empname);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEmployeeid(rs.getInt("employeeid"));
				emp.setDepartmentid(rs.getInt("departmentid"));
				emp.setEmail(rs.getString("email"));
				emp.setEmployeename(rs.getString("employeename"));
				emp.setPassword(rs.getString("password"));
				emp.setPhone(rs.getString("phone"));
 				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emplist;
	}
	
	public List<Employee> pageSum(String username,String empname){
		List<Employee> emplist = new ArrayList<Employee>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select rownum,employeeid," +
				"employeename,username,phone,email,departmentid," +
				"password from employee where username=?" +
				" and employeename=?" ;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, empname);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setUsername(username);
				emp.setEmployeeid(rs.getInt("employeeid"));
				emp.setDepartmentid(rs.getInt("departmentid"));
				emp.setEmail(rs.getString("email"));
				emp.setEmployeename(rs.getString("employeename"));
				emp.setPassword(rs.getString("password"));
				emp.setPhone(rs.getString("phone"));
 				emplist.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emplist;
	}
}
