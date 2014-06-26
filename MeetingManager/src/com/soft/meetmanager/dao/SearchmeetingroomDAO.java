package com.soft.meetmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.soft.meetmanager.model.Employee;
import com.soft.meetmanager.model.Meeting;
import com.soft.meetmanager.util.ConnectionFactory;

public class SearchmeetingroomDAO {
	//,Date meetingfromdate,Date meetingtodate
	public List lookingMeeting(String meetingname,String roomname,Date reservefromdate,Date reservetodate){
		List list=new ArrayList();
		Connection conn=ConnectionFactory.getConnection();
		//Employee emp=new Employee();
		
		String sql="select meetingname,roomname,starttime,endtime,reservationtime from meeting  ";
		try {
			Statement  stmt = conn.createStatement();
			
			ResultSet rs =stmt.executeQuery(sql);
			while(rs.next()){
				Meeting meet=new Meeting();
				meet.setMeetingname(rs.getString("meetingroom"));
				meet.setRoomname(rs.getString("roomname"));
				meet.setStarttime(rs.getDate("starttime"));
				meet.setEndtime(rs.getDate("endtime"));
				meet.setReservationtime(rs.getDate("reservationtime"));
				list.add(meet);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
