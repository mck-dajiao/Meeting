package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.soft.meetmanager.model.Meeting;
import com.soft.meetmanager.util.ConnectionFactory;

public class SelectmymeetingDAO {
	public List<Meeting> selectMymeet(int empid){
		List<Meeting> mtList = new ArrayList<Meeting>();
		Connection conn = ConnectionFactory.getConnection();
		String sql = "select meeting.meetingid, meeting.meetingname, " +
				"meeting.starttime,meeting.endtime,meeting.Reservationtime," +
				"meetingroom.roomname " +
				"from meeting,meetingroom " +
				"where meeting.roomid=meetingroom.roomid " +
				"and meeting.reservationistid="+empid;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
	 			Meeting mt = new Meeting();
	 			mt.setMeetingid(rs.getInt("meetingid"));
				mt.setMeetingname(rs.getString("meetingname"));
				mt.setStarttime(rs.getDate("starttime"));
				mt.setEndtime(rs.getDate("endtime"));
				mt.setReservationtime(rs.getDate("reservationtime"));
				mt.setRoomname(rs.getString("roomname"));
				//mt.setMeetingname(rs.getString("roomname"));
				mtList.add(mt);
			}
	 	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mtList;
		}
}
