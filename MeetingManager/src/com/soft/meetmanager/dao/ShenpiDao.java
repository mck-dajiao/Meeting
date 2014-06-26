package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.soft.meetmanager.util.ConnectionFactory;

public class ShenpiDao {
	
	public int shenpi(int userid){
		int spFlag = 0;
		Connection conn = ConnectionFactory.getConnection();
		String sql = "update employee set status='Í¨¹ý' where employeeid="+userid;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			spFlag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return spFlag;
	}
}
