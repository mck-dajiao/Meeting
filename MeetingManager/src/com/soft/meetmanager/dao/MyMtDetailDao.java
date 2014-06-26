package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.soft.meetmanager.model.Meeting;
import com.soft.meetmanager.util.ConnectionFactory;

public class MyMtDetailDao {
	
	public Meeting meetingDetail(int meetingid){
		Meeting mt = new Meeting();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select * from meeting where meetingid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, meetingid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				mt.setMeetingid(rs.getInt("meetingid"));
				mt.setMeetingname(rs.getString("meetingname"));
				mt.setNumberofparticipants(rs.getInt("numberofparticipants"));
				mt.setStarttime(rs.getDate("starttime"));
				mt.setEndtime(rs.getDate("endtime"));
				mt.setReservationtime(rs.getDate("reservationtime"));
				mt.setCanceledtime(rs.getDate("canceledtime"));
				mt.setDescription(rs.getString("description"));
				mt.setPeoplename(rs.getString("peoplename"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mt;
		
	}
}
