package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.soft.meetmanager.model.Meeting;
import com.soft.meetmanager.util.ConnectionFactory;

public class MybookingDAO {
public List mybooking(){
	List list=new ArrayList();
	Connection conn=ConnectionFactory.getConnection();
	String sql="select meetingid, meetingname,Roomid,Starttime,Endtime,Reservationtime from meeting where reservationisid='1'";
	try {
		Statement state=conn.createStatement();
		ResultSet rs =state.executeQuery(sql);
		while(rs.next()){
			String meetingname=rs.getString("meetingname");
			Integer  roomid=rs.getInt("roomid");
			Date starttime=rs.getDate("starttime");
			Date endtime=rs.getDate("endtime");
			Date reservationtime=rs.getDate("reservationtime");
			Meeting meeting=new Meeting();
			meeting.setMeetingname(meetingname);
			meeting.setRoomid(roomid);
			meeting.setStarttime(starttime);
			meeting.setEndtime(endtime);
			meeting.setReservationtime(reservationtime);
			meeting.setMeetingid(rs.getInt("meetingid"));
			list.add(meeting);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}
}
