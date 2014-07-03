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
				
				System.out.println("add notify:" + notify.getTopic());
				list.add(notify);
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
	}
	
	public static List<Notification> getChangeInfoList(String id){
		return null;
	}
	
	public static List<MeetingRecord> getRecordList(String id){
		return null;
	}
}
