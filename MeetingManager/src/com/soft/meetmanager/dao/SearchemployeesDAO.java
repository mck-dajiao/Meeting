package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soft.meetmanager.model.Employee;
import com.soft.meetmanager.model.MeetingRoom;
import com.soft.meetmanager.util.ConnectionFactory;

public class SearchemployeesDAO {
	public List lookingEmp(String username1,String employeename1,String status1){
		List list=new ArrayList();
		Connection conn=ConnectionFactory.getConnection();
		//Employee emp=new Employee();
		
		String sql="select employeename,userName,phone,email from  employee where username='"+username1+"'and employeename='"+employeename1+"' and status='"+status1+"' ";
		try {
			Statement  stmt = conn.createStatement();
			
			ResultSet rs =stmt.executeQuery(sql);
			while(rs.next()){
				String employeename=rs.getString("employeename");
				String username=rs.getString("userName");
				String phone=rs.getString("phone");
				String email=rs.getString("email");
				Employee emp=new Employee();
				emp.setEmployeename(employeename);
				emp.setUsername(username);
				emp.setPhone(phone);
				emp.setEmail(email);
				list.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
