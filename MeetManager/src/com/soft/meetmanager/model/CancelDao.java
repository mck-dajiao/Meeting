package com.soft.meetmanager.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.soft.meetmanager.util.ConnectionFactory;

import com.soft.meetmanager.util.ConnectionFactory;

public class CancelDao {
	
	public int cancelMeeting(int mtid){
		int delFlag = 0;
		Connection conn = ConnectionFactory.getConnection();
		String sql = "delete from meeting where meetingid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mtid);
			delFlag = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return delFlag;
	}
}
