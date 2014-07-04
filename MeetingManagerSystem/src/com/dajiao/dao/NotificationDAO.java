package com.dajiao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dajiao.model.MeetingRecord;
import com.dajiao.model.Notification;
import com.dajiao.util.ConnectionFactory;

public class NotificationDAO {

	public NotificationDAO() {
		// TODO Auto-generated constructor stub
	}

	// invite message
	public static List<Notification> getInviteList(String useraccount){

		List<Notification> list = new ArrayList<Notification>();
		Connection conn = ConnectionFactory.getConnection();
		
		if(conn==null) return null;
		try {
			PreparedStatement pSt = null;
			System.out.println("useraccount :" + useraccount);
			String sql = "select * from notification where type='invite' and useraccount='"
					+ useraccount + "'";
			pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery(sql);
			
			while(rs.next()==true){
				Notification notify = new Notification();
				
				notify.setId(rs.getInt(1));
				notify.setUseraccount(rs.getString(2));
				notify.setTopic(rs.getString(3));
				notify.setMeetingRoom(rs.getString(4));
				notify.setStarttime(rs.getTimestamp(5));
				notify.setEndtime(rs.getTimestamp(6));
				notify.setDetail(rs.getString(7));
				
				System.out.println("add invite notify:" + notify.getTopic());
				list.add(notify);
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	public static List<Notification> getChangeInfoList(String useraccount){
		List<Notification> list = new ArrayList<Notification>();
		Connection conn = ConnectionFactory.getConnection();
		
		if(conn==null) return null;
		try {
			PreparedStatement pSt = null;
			System.out.println("useraccount :" + useraccount);
			String sql = "select * from notification where type='change' and useraccount='"
					+ useraccount + "'";
			pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery(sql);
			
			while(rs.next()==true){
				Notification notify = new Notification();
				
				notify.setId(rs.getInt(1));
				notify.setUseraccount(rs.getString(2));
				notify.setTopic(rs.getString(3));
				notify.setMeetingRoom(rs.getString(4));
				notify.setStarttime(rs.getTimestamp(5));
				notify.setEndtime(rs.getTimestamp(6));
				notify.setDetail(rs.getString(7));
				
				System.out.println("add change notify:" + notify.getTopic());
				list.add(notify);
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return null;
	}
	
	public static List<MeetingRecord> getRecordList(String useraccount){
		
		List<MeetingRecord> list = new ArrayList<MeetingRecord>();
		Connection conn = ConnectionFactory.getConnection();

		if (conn == null)
			return null;
		try {
			PreparedStatement pSt = null;
			System.out.println("useraccount :" + useraccount);
			String sql = "select meetingid,topic,bookpeople,detail from  meeting natural join summary where useraccount = '"
					+ useraccount + "'";

			pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery(sql);

			while (rs.next() == true) {
				MeetingRecord record = new MeetingRecord();
				record.setId(rs.getInt(1));
				record.setTopic(rs.getString(2));
				record.setName(rs.getString(3));
				record.setDetail(rs.getString(4));

				System.out.println("add record:" + record.getTopic());
				list.add(record);
			}
			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
