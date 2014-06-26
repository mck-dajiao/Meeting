package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.meetmanager.model.Employee;
import com.soft.meetmanager.util.ConnectionFactory;

public class LookingForDao {

	public List lookfor(){
		List list = new ArrayList();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from employee where status='Œ¥…Û≈˙'";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp.setEmployeeid(rs.getInt("employeeid"));
				emp.setEmployeename(rs.getString("employeename"));
				emp.setUsername(rs.getString("username"));
				emp.setPhone(rs.getString("phone"));
				list.add(emp);
 			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
